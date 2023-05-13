package com.multi.mariage.product.controller;

import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.response.ProductFindResponse;
import com.multi.mariage.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
}
