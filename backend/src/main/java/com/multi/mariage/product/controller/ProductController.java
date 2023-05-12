package com.multi.mariage.product.controller;

import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product/save")
    public ResponseEntity<Void> create(@RequestBody @Valid ProductSaveRequest request) {
        productService.create(request);
        return ResponseEntity.ok().build();
    }
}
