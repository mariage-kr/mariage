package com.multi.mariage.product.service;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.dto.response.*;
import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import com.multi.mariage.product.vo.FoodCountsVO;
import com.multi.mariage.product.vo.PairingFoodsVO;
import com.multi.mariage.product.vo.ProductsVO;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.vo.ReviewRateVO;
import com.multi.mariage.storage.service.ImageService;
import com.multi.mariage.storage.service.StorageService;
import com.multi.mariage.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class ProductFindService {
    private final ImageService imageService;
    private final StorageService storageService;
    private final ProductRepository productRepository;
    private final WeatherService weatherService;

    public ProductFindResponse findProducts() {
        List<ProductsVO> productValues = getProductValues();

        return ProductFindResponse.builder()
                .product(productValues)
                .length(productValues.size())
                .build();
    }

    public ProductInfoResponse findProductInfo(Long productId) {
        Product product = findById(productId);
        String imageUrl = imageService.getImageUrl(product.getImage().getName());

        return ProductInfoResponse.from(product, imageUrl);
    }

    public ProductContentResponse findProductContent(Long productId) {
        Product product = findById(productId);
        String imageUrl = imageService.getImageUrl(product.getImage().getName());
        List<Review> reviews = product.getReviews();
        double reviewRate = getReviewAverageRate(reviews);

        return ProductContentResponse.from(product, imageUrl, reviewRate);
    }

    public ProductReviewStatsResponse findProductReviewStats(Long productId) {
        Product product = findById(productId);
        List<Review> reviews = product.getReviews();
        double reviewAverageRate = getReviewAverageRate(reviews);

        int reviewCount = reviews.size();
        List<ReviewRateVO> percentageList = getReviewPercentages(productId);
        return ProductReviewStatsResponse.from(product, reviewAverageRate, reviewCount, percentageList);
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_IS_NOT_EXIST));
    }

    public List<ProductMainCardResponse> findWeather(int size) {
        List<Product> products = productRepository.findWeather(size, weatherService.findLatestWeather());

        return products.stream().map(this::toProductMainCard).toList();
    }

    public List<ProductMainCardResponse> findWeek(int size) {
        List<Product> products = productRepository.findWeek(size);

        return products.stream().map(this::toProductMainCard).toList();
    }

    public List<ProductMainCardResponse> findMonth(int size) {
        List<Product> products = productRepository.findMonth(size);

        return products.stream().map(this::toProductMainCard).toList();
    }

    public List<ProductMainCardResponse> findTotal(int size) {
        List<Product> products = productRepository.findTotal(size);

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
                .reviewRate(getReviewAverageRate(reviews))
                .country(country.getValue())
                .countryImageUrl(imageService.getImageUrl(country.getFlagName()))
                .build();
    }



    private List<ProductsVO> getProductValues() {
        List<Product> products = productRepository.findAll();

        return products.stream()
                .map(product -> {
                    String imageUrl = imageService.getImageUrl(product.getImage().getName());
                    return ProductsVO.from(product, product.getUpperCategory(), product.getLowerCategory(), product.getCountry(), imageUrl);
                })
                .toList();
    }

    private double getReviewAverageRate(List<Review> reviews) {
        long totalRate = 0L;
        for (Review review : reviews) {
            totalRate += review.getProductRate();
        }
        return Math.round((double) totalRate / reviews.size());
    }

    public List<ReviewRateVO> getReviewPercentages(Long productId) {
        Product product = findById(productId);
        List<Review> reviews = product.getReviews();
        int reviewCount = reviews.size();

        Map<Integer, Integer> reviewRateCounts = getRateCounts(reviews);
        List<ReviewRateVO> percentageList = new ArrayList<>();
        getPercentage(reviewCount, reviewRateCounts, percentageList);

        return percentageList;
    }

    private static void getPercentage(int reviewCount, Map<Integer, Integer> reviewRateCounts, List<ReviewRateVO> percentageList) {
        for (int reviewRate = 1; reviewRate <= 5; reviewRate++) {
            int count = reviewRateCounts.getOrDefault(reviewRate, 0);
            int percentage = (int) Math.round((double) count / reviewCount * 100);
            percentageList.add(ReviewRateVO.from(reviewRate, percentage));
        }
    }

    private static Map<Integer, Integer> getRateCounts(List<Review> reviews) {
        Map<Integer, Integer> reviewRateCounts = new HashMap<>();
        for (Review review : reviews) {
            int reviewRate = review.getProductRate();
            reviewRateCounts.put(reviewRate, reviewRateCounts.getOrDefault(reviewRate, 0) + 1);
        }
        return reviewRateCounts;
    }

    private static Map<FoodCategory, Integer> getFoodCounts(List<Review> reviews) { // 음식별 리뷰의 개수
        Map<FoodCategory, Integer> foodCounts = new HashMap<>();
        for (Review review : reviews) {
            FoodCategory food = review.getFoodCategory();
            foodCounts.put(food, foodCounts.getOrDefault(food, 0) + 1);
        }
        return foodCounts;
    }

    public List<FoodCountsVO> getFoodCountList(Long productId) {
        Product product = findById(productId);
        List<Review> reviews = product.getReviews();

        Map<FoodCategory, Integer> foodCounts = getFoodCounts(reviews);
        List<FoodCountsVO> foodCountList = new ArrayList<>();
        List<FoodCategory> foodCategories = Arrays.asList(FoodCategory.values());

        for (FoodCategory foodCategory : foodCategories) {
            String food = String.valueOf(foodCategory.getName());
            int count = foodCounts.getOrDefault(foodCategory, 0);
            foodCountList.add(FoodCountsVO.from(food, count));
        }
        Collections.sort(foodCountList, Comparator.comparingInt(FoodCountsVO::getCount).reversed());    // 리뷰가 많은 순 정렬

        return foodCountList.subList(0, Math.min(foodCountList.size(), 5));     // 리뷰가 많은 순 top 5
    }

    public List<FoodCountsVO> getFoodsByReviewCount(Long productId) {
        Product product = findById(productId);
        List<FoodCountsVO> foodCountList = getFoodCountList(product.getId());
        return foodCountList;
    }
}
