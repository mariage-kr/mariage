package com.multi.mariage.product.controller;

import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.request.ProductUpdateRequest;
import com.multi.mariage.product.dto.response.ProductFindResponse;
import com.multi.mariage.product.dto.response.ProductInfoResponse;
import com.multi.mariage.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;

    @PostMapping("/user/product/save")
    public ResponseEntity<Void> save(@RequestBody @Valid ProductSaveRequest request) {
        productService.save(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/product/find")
    public ResponseEntity<ProductFindResponse> findProducts() {
        ProductFindResponse response = productService.findProducts();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/product/info")
    public ResponseEntity<ProductInfoResponse> findProductInfo(@Param("productId") Long productId) {
        ProductInfoResponse response = productService.findProductInfo(productId);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/user/product/update")
    public ResponseEntity<Void> update(@RequestBody ProductUpdateRequest request) {
        productService.update(request);
        return ResponseEntity.ok().build();
    }
}
