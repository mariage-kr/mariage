package com.multi.mariage.product.controller;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.request.ProductSaveRequest;
import com.multi.mariage.product.dto.request.ProductUpdateRequest;
import com.multi.mariage.product.dto.response.ProductSaveResponse;
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
    public ResponseEntity<ProductSaveResponse> save(@RequestBody @Valid ProductSaveRequest request) {
        Product product = productModifyService.save(request);
        ProductSaveResponse response = new ProductSaveResponse(product.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /* TODO: 2023/05/24 테스트 코드 필요 */
    @PatchMapping("/user/product/update")
    public ResponseEntity<Void> update(@RequestBody ProductUpdateRequest request) {
        productModifyService.update(request);
        return ResponseEntity.ok().build();
    }
}
