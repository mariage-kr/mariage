package com.multi.mariage.product.service;

import com.multi.mariage.category.domain.Food;
import com.multi.mariage.category.service.FoodCategoryService;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.global.utils.PagingUtil;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.dto.condition.RecommendCond;
import com.multi.mariage.product.dto.request.ProductFindByFilterRequest;
import com.multi.mariage.product.dto.request.ProductSearchCond;
import com.multi.mariage.product.dto.response.ProductDetailPageResponse;
import com.multi.mariage.product.dto.response.ProductFilterResponse;
import com.multi.mariage.product.dto.response.ProductInfoResponse;
import com.multi.mariage.product.dto.response.ProductMainCardResponse;
import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import com.multi.mariage.product.vo.*;
import com.multi.mariage.product.vo.filter.ProductCountryFilterVO;
import com.multi.mariage.product.vo.filter.ProductFilterVO;
import com.multi.mariage.product.vo.filter.ProductFoodFilterVO;
import com.multi.mariage.product.vo.filter.ProductReviewFilterVO;
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

    public ProductFilterResponse search(ProductSearchCond cond) {
        return null;
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

    private List<ProductDetailVO> getProductValues() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> {
                    String imageUrl = imageService.getImageUrl(product.getImage().getName());
                    return ProductDetailVO.from(product, product.getUpperCategory(), product.getLowerCategory(), product.getCountry(), imageUrl);
                })
                .toList();
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

        Map<Integer, Integer> reviewRateCounts = getRateCounts(reviews);

        return getPercentage(reviewCount, reviewRateCounts);
    }

    private Map<Integer, Integer> getRateCounts(List<Review> reviews) {
        Map<Integer, Integer> reviewRateCounts = new HashMap<>();
        for (Review review : reviews) {
            int reviewRate = review.getProductRate();
            reviewRateCounts.put(reviewRate, reviewRateCounts.getOrDefault(reviewRate, 0) + 1);
        }
        return reviewRateCounts;
    }

    private List<ReviewRateVO> getPercentage(int reviewCount, Map<Integer, Integer> reviewRateCounts) {
        List<ReviewRateVO> percentageList = new ArrayList<>();

        for (int reviewRate = 5; reviewRate >= 1; reviewRate--) {
            int count = reviewRateCounts.getOrDefault(reviewRate, 0);
            int percentage = (int) Math.round((double) count / reviewCount * 100);
            percentageList.add(ReviewRateVO.from(reviewRate, percentage));
        }
        return percentageList;
    }

    public ProductReviewStatsVO getProductReviewStats(Long productId) {
        Product product = findById(productId);
        List<ReviewRateVO> percentageList = getReviewPercentages(productId);

        return ProductReviewStatsVO.from(product, percentageList);
    }

    public ProductContentVO getProductContent(Long productId) {
        Product product = findById(productId);
        String imageUrl = imageService.getImageUrl(product.getImage().getName());

        return ProductContentVO.from(product, imageUrl, product.getAvgReviewRate());
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

    public ProductInfoResponse findProductInfo(Long productId) {
        Product product = findById(productId);
        String imageUrl = imageService.getImageUrl(product.getImage().getName());

        return ProductInfoResponse.from(product, imageUrl);
    }
}
