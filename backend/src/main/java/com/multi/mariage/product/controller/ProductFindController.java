package com.multi.mariage.product.controller;

import com.multi.mariage.product.dto.response.ProductFindResponse;
import com.multi.mariage.product.dto.response.ProductInfoResponse;
import com.multi.mariage.product.dto.response.ProductMainCardResponse;
import com.multi.mariage.product.service.ProductFindService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /* TODO: 2023/05/19 추후 해당 권한은 관리자만 가능하게 할 예정입니다. */
    @GetMapping("/user/product/info")
    public ResponseEntity<ProductInfoResponse> findProductInfo(@Param("productId") Long productId) {
        ProductInfoResponse response = productFindService.findProductInfo(productId);
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
}
