package com.multi.mariage.product.service;

import com.multi.mariage.category.domain.Food;
import com.multi.mariage.category.service.FoodCategoryService;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.global.utils.PagingUtil;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.dto.condition.RecommendCond;
import com.multi.mariage.product.dto.request.ProductFindByFilterRequest;
import com.multi.mariage.product.dto.response.*;
import com.multi.mariage.product.dto.response.temp.ProductContentResponse;
import com.multi.mariage.product.dto.response.temp.ProductReviewRankCountResponse;
import com.multi.mariage.product.dto.response.temp.ProductReviewRankRateResponse;
import com.multi.mariage.product.dto.response.temp.ProductReviewStatsResponse;
import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import com.multi.mariage.product.vo.*;
import com.multi.mariage.product.vo.filter.*;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.storage.service.ImageService;
import com.multi.mariage.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductFindService extends PagingUtil {
    private final ImageService imageService;
    private final ProductRepository productRepository;
    private final WeatherService weatherService;
    private final FoodCategoryService foodCategoryService;

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_IS_NOT_EXIST));
    }

    public ProductFindResponse findProducts() {
        List<ProductDetailVO> productValues = getProductValues();

        return ProductFindResponse.builder()
                .product(productValues)
                .length(productValues.size())
                .build();
    }

    public ProductContentResponse findProductContent(Long productId) {
        Product product = findById(productId);
        String imageUrl = imageService.getImageUrl(product.getImage().getName());

        return ProductContentResponse.from(product, imageUrl, product.getAvgReviewRate());
    }

    public ProductReviewStatsResponse findProductReviewStats(Long productId) {
        Product product = findById(productId);
        List<ReviewRateVO> percentageList = getReviewPercentages(productId);

        return ProductReviewStatsResponse.from(product, percentageList);
    }

    public List<ProductMainCardResponse> findWeather(int size) {
        List<Product> products = productRepository.findRecommendProductsByWeather(size, weatherService.findLatestWeather());

        return products.stream().map(this::toProductMainCard).toList();
    }

    public List<ProductMainCardResponse> findRecommendDate(int size, String option) {
        RecommendCond cond = RecommendCond.builder()
                .size(size)
                .option(option)
                .build();

        List<Product> products = productRepository.findRecommendProductsByDate(cond);

        return products.stream().map(this::toProductMainCard).toList();
    }

    private ProductMainCardResponse toProductMainCard(Product product) {
        List<Review> reviews = product.getReviews();
        Country country = product.getCountry();

        return ProductMainCardResponse.builder()
                .productId(product.getId())
                .productName(product.getName())
                .productImageUrl(imageService.getImageUrl(product.getImage().getName()))
                .reviewCount(reviews.size())
                .reviewRate(product.getAvgReviewRate())
                .country(country.getValue())
                .countryId(country.getId())
                .build();
    }

    public ProductDetailPageResponse findFullInfoByPage(Long productId) {
        Product product = findById(productId);
        ProductContentVO content = getProductContent(productId);
        ProductReviewStatsVO rating = getProductReviewStats(productId);
        List<FoodRateRankingVO> foodRateRanking = getFoodsOrderByRate(productId);
        List<FoodCountRankingVO> foodCountRanking = getFoodsOrderByCount(productId);
        return ProductDetailPageResponse.from(product.getId(), content, rating, foodRateRanking, foodCountRanking);
    }

    private List<ProductDetailVO> getProductValues() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> {
                    String imageUrl = imageService.getImageUrl(product.getImage().getName());
                    return ProductDetailVO.from(product, product.getUpperCategory(), product.getLowerCategory(), product.getCountry(), imageUrl);
                })
                .toList();
    }

    public ProductFilterResponse findByFilter(ProductFindByFilterRequest cond) {
        List<Product> products = productRepository.findProductsByFilter(cond);
        List<ProductFilterVO> contents = getContentsByFilter(products);

        Long totalCount = productRepository.countProductWithFilter(cond);
        int totalPages = getTotalPages(cond.getPageSize(), totalCount);

        return ProductFilterResponse.builder()
                .contents(contents)
                .pageNumber(cond.getPageNumber())
                .totalCount(totalCount)
                .pageSize(cond.getPageSize())
                .totalPages(totalPages)
                .isFirstPage(isFirstPage(cond.getPageNumber()))
                .isLastPage(isLastPage(cond.getPageNumber(), totalPages))
                .build();
    }

    public ProductReviewRankRateResponse findFoodsOrderByRate(Long productId) {
        Product product = findById(productId);

        List<Food> foodList = foodCategoryService.findFoodsByProduct(product, 5);
        List<FoodRateRankingVO> foodRateList = foodList.stream()
                .map(food -> FoodRateRankingVO.from(food.getCategory().getId(), food.getCategory().getName(), food.getAvgFoodRate()))
                .toList();

        return ProductReviewRankRateResponse.from(product, foodRateList);
    }

    public ProductReviewRankCountResponse findFoodsOrderByCount(Long productId) {
        Product product = findById(productId);

        List<Food> foodList = foodCategoryService.findFoodsOrderByReviewCount(product, 5);
        List<FoodCountRankingVO> foodCountList = foodList.stream()
                .map(food -> FoodCountRankingVO.from(food.getCategory().getId(), food.getCategory().getName(), food.getReviews().size()))
                .toList();

        return ProductReviewRankCountResponse.from(product, foodCountList);
    }

    private List<ProductFilterVO> getContentsByFilter(List<Product> products) {
        List<ProductFilterVO> contents = new LinkedList<>();
        for (Product product : products) {
            String imageUrl = imageService.getImageUrl(product.getImage().getName());

            List<Food> foods = foodCategoryService.findFoodsByProduct(product, 3);
            List<ProductFoodFilterVO> foodList = foods.stream().map(ProductFoodFilterVO::from).toList();

            ProductFilterVO content = ProductFilterVO.from(product, imageUrl,
                    ProductCountryFilterVO.from(product),
                    ProductReviewFilterVO.from(product),
                    foodList);
            contents.add(content);
        }
        return contents;
    }

    public List<ReviewRateVO> getReviewPercentages(Long productId) {
        Product product = findById(productId);
        List<Review> reviews = product.getReviews();

        int reviewCount = reviews.size();
        int[] reviewScore = new int[6];    // 별점 1~5
        List<ReviewRateVO> percentageList = new ArrayList<>();

        getRateCounts(reviews, reviewScore);
        getPercentage(reviewCount, reviewScore, percentageList);
        return percentageList;
    }

    private void getRateCounts(List<Review> reviews, int[] reviewRateCounts) {  // 점수별 리뷰 개수
        for (Review review : reviews) {
            int reviewRate = review.getProductRate();
            reviewRateCounts[reviewRate]++;
        }
    }

    private void getPercentage(int reviewCount, int[] reviewScoreCounts, List<ReviewRateVO> percentageList) {   // 비율 계산
        for (int reviewScore = 1; reviewScore <= 5; reviewScore++) {
            int count = reviewScoreCounts[reviewScore];
            int percentage = (int) Math.round((double) count / reviewCount * 100);
            percentageList.add(ReviewRateVO.from(reviewScore, percentage));
        }
    }

    public ProductInfoResponse findProductInfo(Long productId) {
        Product product = findById(productId);
        String imageUrl = imageService.getImageUrl(product.getImage().getName());

        return ProductInfoResponse.from(product, imageUrl);
    }

    public ProductContentVO getProductContent(Long productId) {
        Product product = findById(productId);
        String imageUrl = imageService.getImageUrl(product.getImage().getName());

        return ProductContentVO.from(product, imageUrl, product.getAvgReviewRate());
    }

    public ProductReviewStatsVO getProductReviewStats(Long productId) {
        Product product = findById(productId);
        List<ReviewRateVO> percentageList = getReviewPercentages(productId);

        return ProductReviewStatsVO.from(product, percentageList);
    }

    public List<FoodRateRankingVO> getFoodsOrderByRate(Long productId) {
        Product product = findById(productId);
        List<Food> foodList = foodCategoryService.findFoodsByProduct(product, 5);   // 제품에 대한 음식 리뷰 별점이 높은 순으로 5개 가져옴

        return foodList.stream()
                .map(food -> FoodRateRankingVO.from(food.getCategory().getId(), food.getCategory().getName(), food.getAvgFoodRate()))
                .toList();
    }

    public List<FoodCountRankingVO> getFoodsOrderByCount(Long productId) {
        Product product = findById(productId);
        List<Food> foodList = foodCategoryService.findFoodsOrderByReviewCount(product, 5);    // 제품에 대한 음식 리뷰 개수가 많은 순으로 5개 가져옴

        return foodList.stream()
                .map(food -> FoodCountRankingVO.from(food.getCategory().getId(), food.getCategory().getName(), food.getReviews().size()))
                .toList();
    }
}
