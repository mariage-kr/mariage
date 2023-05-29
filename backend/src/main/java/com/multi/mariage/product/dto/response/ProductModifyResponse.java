package com.multi.mariage.product.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductModifyResponse {
    private Long productId;

    public ProductModifyResponse(Long productId) {
        this.productId = productId;
    }
}
