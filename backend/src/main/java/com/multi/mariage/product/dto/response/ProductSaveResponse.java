package com.multi.mariage.product.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductSaveResponse {
    private Long productId;

    public ProductSaveResponse(Long productId) {
        this.productId = productId;
    }
}
