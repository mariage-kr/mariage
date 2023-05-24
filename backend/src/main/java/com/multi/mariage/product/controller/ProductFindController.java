package com.multi.mariage.product.controller;

import com.multi.mariage.product.dto.request.ProductFindByFilterRequest;
import com.multi.mariage.product.dto.response.*;
import com.multi.mariage.product.service.ProductFindService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ProductFindController {
    private final ProductFindService productFindService;

    @GetMapping("/product/find")
    public ResponseEntity<ProductFindResponse> findProducts() {
        ProductFindResponse response = productFindService.findProducts();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/recommend/weather")
    public ResponseEntity<List<ProductMainCardResponse>> findWeather(@Param("size") int size) {
        List<ProductMainCardResponse> response = productFindService.findWeather(size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/recommend/date")
    public ResponseEntity<List<ProductMainCardResponse>> findRecommendProducts(@Param("size") int size,
                                                                               @Param("option") String option) {
        List<ProductMainCardResponse> response = productFindService.findRecommendDate(size, option);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/find/filter")
    public ResponseEntity<ProductFilterResponse> findProductsByFilter(ProductFindByFilterRequest cond) {
        ProductFilterResponse response = productFindService.findByFilter(cond);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/detail/content/{id}")
    public ResponseEntity<ProductContentResponse> findProductContentById(@PathVariable Long id) {
        ProductContentResponse response = productFindService.findProductContent(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/detail/stats/{id}")
    public ResponseEntity<ProductReviewStatsResponse> findProductReviewStatsById(@PathVariable Long id) {
        ProductReviewStatsResponse response = productFindService.findProductReviewStats(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/product/detail/food/rate/{id}")
    public ResponseEntity<ProductReviewRankRateResponse> findFoodRateRankingById(@PathVariable Long id) {
        ProductReviewRankRateResponse response = productFindService.findRankingByReviewRate(id);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/product/detail/food/count/{id}")
    public ResponseEntity<ProductReviewRankCountResponse> findFoodCountRankingById(@PathVariable Long id) {
        ProductReviewRankCountResponse response = productFindService.findRankingByReviewCount(id);
        return ResponseEntity.ok(response);
    }

    /* TODO: 2023/05/19 추후 해당 권한은 관리자만 가능하게 할 예정입니다. */
    @GetMapping("/user/product/info")
    public ResponseEntity<ProductInfoResponse> findProductInfo(@Param("productId") Long productId) {
        ProductInfoResponse response = productFindService.findProductInfo(productId);
        return ResponseEntity.ok(response);
    }
}
