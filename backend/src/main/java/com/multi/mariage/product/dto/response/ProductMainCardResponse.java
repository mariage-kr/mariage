package com.multi.mariage.product.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductMainCardResponse {
    private Long productId;
    private String productName;
    private String productImageUrl;
    private int reviewCount;
    private double reviewRate;
    private String country;
    private String countryImageUrl;

    @Builder
    public ProductMainCardResponse(Long productId, String productName, String productImageUrl, int reviewCount,
                                   double reviewRate, String country, String countryImageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.productImageUrl = productImageUrl;
        this.reviewCount = reviewCount;
        this.reviewRate = reviewRate;
        this.country = country;
        this.countryImageUrl = countryImageUrl;
    }
}
