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

    @GetMapping("/user/product/info")
    public ResponseEntity<ProductInfoResponse> findProductInfo(@Param("productId") Long productId) {
        ProductInfoResponse response = productFindService.findProductInfo(productId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/product/total")
    public ResponseEntity<List<ProductMainCardResponse>> findTotal() {
        List<ProductMainCardResponse> response = productFindService.findTotal();
        return ResponseEntity.ok(response);
    }
}
