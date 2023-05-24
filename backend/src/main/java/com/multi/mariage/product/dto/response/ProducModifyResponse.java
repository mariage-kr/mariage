package com.multi.mariage.product.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProducModifyResponse {
    private Long productId;

    public ProducModifyResponse(Long productId) {
        this.productId = productId;
    }
}
