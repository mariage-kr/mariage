package com.multi.mariage.product.service;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.domain.ProductRepository;
import com.multi.mariage.product.dto.response.*;
import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import com.multi.mariage.product.vo.PairingFoodCountsVO;
import com.multi.mariage.product.vo.PairingFoodRatesVO;
import com.multi.mariage.product.vo.ProductsVO;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.vo.ReviewRateVO;
import com.multi.mariage.storage.service.ImageService;
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
public class ProductDetailFindService {
    private final ImageService imageService;
    private final ProductRepository productRepository;

    public ProductContentVO findProductContent(Long productId) {  // 제품 상세페이지 제품 정보 조회
        Product product = findById(productId);
        String imageUrl = imageService.getImageUrl(product.getImage().getName());
        List<Review> reviews = product.getReviews();
        double reviewRate = getReviewAverageRate(reviews);

        return ProductContentVO.from(product, imageUrl, reviewRate);
    }

    public ProductReviewStatsVO findProductReviewStats(Long productId) {  // 제품에 대한 리뷰 통계 조회
        Product product = findById(productId);
        List<Review> reviews = product.getReviews();
        double reviewAverageRate = getReviewAverageRate(reviews);

        int reviewCount = reviews.size();
        List<ReviewRateVO> percentageList = getReviewPercentages(productId);
        return ProductReviewStatsVO.from(product, reviewAverageRate, reviewCount, percentageList);
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductException(ProductErrorCode.PRODUCT_IS_NOT_EXIST));
    }

    public List<PairingFoodCountsVO> findFoodsByReviewCount(Long productId) {    // controller에서 사용하는 리뷰 개수 순 조회
        Product product = findById(productId);
        List<PairingFoodCountsVO> foodCountList = getFoodCountList(product.getId());
        return foodCountList;
    }

    public List<PairingFoodRatesVO> findFoodsByReviewRate(Long productId) {    // controller에서 사용하는 리뷰 점수 순 조회
        Product product = findById(productId);
        List<PairingFoodRatesVO> foodCountList = getFoodRateList(product.getId());
        return foodCountList;
    }

    public List<PairingFoodRatesVO> findProductDetail(Long productId) {    // controller에서 사용하는 리뷰 점수 순 조회
        Product product = findById(productId);
        List<PairingFoodRatesVO> foodCountList = getFoodRateList(product.getId());
        return foodCountList;
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
            FoodCategory food = review.getFoodCategory();   // 리뷰의 음식 카테고리 확인
            foodCounts.put(food, foodCounts.getOrDefault(food, 0) + 1);
        }
        return foodCounts;
    }

    public List<PairingFoodCountsVO> getFoodCountList(Long productId) {     // 리뷰가 많은 순으로 페어링 음식 조회
        Product product = findById(productId);
        List<Review> reviews = product.getReviews();

        Map<FoodCategory, Integer> foodCounts = getFoodCounts(reviews);
        List<PairingFoodCountsVO> foodCountList = new ArrayList<>();

        for (FoodCategory foodCategory : FoodCategory.values()) {
            int id = foodCategory.getId();
//            String imageUrl = imageService.getImageUrl(foodCategory.getImage().getName());    // 음식 관련된 default 이미지?
            String name = String.valueOf(foodCategory.getName());
            int count = foodCounts.getOrDefault(foodCategory, 0);
            foodCountList.add(PairingFoodCountsVO.from(id, name, count));
        }
        Collections.sort(foodCountList, Comparator.comparingInt(PairingFoodCountsVO::getCount).reversed());    // 리뷰가 많은 순 정렬

        return foodCountList.subList(0, 5);     // 리뷰가 많은 순 top 5
    }

    public List<PairingFoodRatesVO> getFoodRateList(Long productId) {     // 리뷰 점수가 높은 순으로 페어링 음식 조회
        Product product = findById(productId);
        List<Review> reviews = product.getReviews();

        Map<FoodCategory, Integer> foodCounts = getFoodCounts(reviews);
        Map<FoodCategory, Integer> foodRates = getFoodRates(reviews);

        List<PairingFoodRatesVO> foodCountList = new ArrayList<>();

        for (FoodCategory foodCategory : FoodCategory.values()) {
            int id = foodCategory.getId();
//            String imageUrl = imageService.getImageUrl(foodCategory.getImage().getName());     // 음식 관련된 default 이미지?
            String name = foodCategory.getName();
            int count = foodCounts.getOrDefault(foodCategory, 0);

            double rate = count > 0 ? (double) foodRates.getOrDefault(foodCategory, 0) / count : 0.0;
            foodCountList.add(PairingFoodRatesVO.from(id, name, rate));
        }

        Collections.sort(foodCountList, Comparator.comparingDouble(PairingFoodRatesVO::getRate).reversed());

        return foodCountList.subList(0, 5);
    }

    private static Map<FoodCategory, Integer> getFoodRates(List<Review> reviews) {
        Map<FoodCategory, Integer> foodRates = new HashMap<>();

        for (Review review : reviews) {
            int foodRate = review.getFoodRate();
            FoodCategory foodCategory = review.getFoodCategory();

            foodRates.put(foodCategory, foodRates.getOrDefault(foodCategory, 0) + foodRate);
        }
        return foodRates;
    }
}
