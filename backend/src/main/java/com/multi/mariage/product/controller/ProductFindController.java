package com.multi.mariage.product.controller;

import com.multi.mariage.product.dto.response.*;
import com.multi.mariage.product.service.ProductDetailFindService;
import com.multi.mariage.product.service.ProductFindService;
import com.multi.mariage.product.vo.PairingFoodCountsVO;
import com.multi.mariage.product.vo.PairingFoodRatesVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ProductFindController {
    private final ProductFindService productFindService;
    private final ProductDetailFindService productDetailFindService;

    @GetMapping("/product/find")
    public ResponseEntity<ProductFindResponse> findProducts() {
        ProductFindResponse response = productFindService.findProducts();
        return ResponseEntity.ok(response);
    }

    /* TODO: 2023/05/19 추후 해당 권한은 관리자만 가능하게 할 예정입니다. */
    @GetMapping("/user/product/info")
    public ResponseEntity<ProductInfoResponse> findProductInfo(@Param("productId") Long productId) {
        ProductInfoResponse response = productFindService.findProductInfo(productId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/detail/content/{id}")
    public ResponseEntity<ProductContentVO> findProductContentById(@PathVariable Long id) {
        ProductContentVO response = productDetailFindService.findProductContent(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/recommend/weather")
    public ResponseEntity<List<ProductMainCardResponse>> findWeather(@Param("size") int size) {
        List<ProductMainCardResponse> response = productFindService.findWeather(size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/recommend/week")
    public ResponseEntity<List<ProductMainCardResponse>> findWeek(@Param("size") int size) {
        List<ProductMainCardResponse> response = productFindService.findWeek(size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/recommend/month")
    public ResponseEntity<List<ProductMainCardResponse>> findMonth(@Param("size") int size) {
        List<ProductMainCardResponse> response = productFindService.findMonth(size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/recommend/total")
    public ResponseEntity<List<ProductMainCardResponse>> findTotal(@Param("size") int size) {
        List<ProductMainCardResponse> response = productFindService.findTotal(size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/detail/stats/{id}")
    public ResponseEntity<ProductReviewStatsVO> findProductReviewStatsById(@PathVariable Long id) {
        ProductReviewStatsVO response = productDetailFindService.findProductReviewStats(id);
        return ResponseEntity.ok(response);
    }

    // TODO: json 확인용이므로 최종 controller 정리 시 삭제
    @GetMapping("/product/detail/food/count/{id}")
    public ResponseEntity<List<PairingFoodCountsVO>> getFoodsByReviewCount(@PathVariable Long id) {
        List<PairingFoodCountsVO> response = productDetailFindService.findFoodsByReviewCount(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/detail/food/rate/{id}")
    public ResponseEntity<List<PairingFoodRatesVO>> getFoodsByReviewRate(@PathVariable Long id) {
        List<PairingFoodRatesVO> response = productDetailFindService.findFoodsByReviewRate(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/detail/{id}")
    public ResponseEntity<ProductContentVO> findProductDetailPageById(@PathVariable Long id) {
        ProductContentVO response = productDetailFindService.findProductContent(id);
        return ResponseEntity.ok(response);
    }
}
