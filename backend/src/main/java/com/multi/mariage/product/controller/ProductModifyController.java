package com.multi.mariage.product.controller;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.request.ProductUpdateRequest;
import com.multi.mariage.product.dto.response.ProductModifyResponse;
import com.multi.mariage.product.service.ProductModifyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class ProductModifyController {
    private final ProductModifyService productModifyService;

    @PostMapping("/user/product/save")
    public ResponseEntity<ProductModifyResponse> save(@RequestBody @Valid ProductSaveRequest request) {
        Product product = productModifyService.save(request);
        ProductModifyResponse response = new ProductModifyResponse(product.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/user/product/update")
    public ResponseEntity<ProductModifyResponse> update(@RequestBody ProductUpdateRequest request) {
        Product product = productModifyService.update(request);
        ProductModifyResponse response = new ProductModifyResponse(product.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
