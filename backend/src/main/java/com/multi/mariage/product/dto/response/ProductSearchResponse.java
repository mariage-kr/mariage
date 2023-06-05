package com.multi.mariage.product.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductSearchResponse {
    private List<String> products;
    private int size;

    @Builder
    private ProductSearchResponse(List<String> products, int size) {
        this.products = products;
        this.size = size;
    }

    public static ProductSearchResponse from(List<String> products) {
        return ProductSearchResponse.builder()
                .products(products)
                .size(products.size())
                .build();
    }
}
