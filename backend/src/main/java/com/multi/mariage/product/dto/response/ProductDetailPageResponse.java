package com.multi.mariage.product.dto.response;

import com.multi.mariage.product.domain.Product;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductDetailPageResponse {
    private Long id;
//    private

    private ProductDetailPageResponse(Product product, String imageUrl, double reviewRate) {
        this.id = product.getId();
//        this.imageId = product.getImage().getId();
//        this.imageUrl = imageUrl;
//        this.name = String.valueOf(product.getName());
//        this.level = product.getLevel().getValue();
//        this.reviewRate = reviewRate;
//        this.info = String.valueOf(product.getInfo());
//        this.countryId = product.getCountry().getId();
//        this.country = product.getCountry().getValue();
    }

    public static ProductDetailPageResponse from(Product product, String imageUrl, double reviewRate) {
        return new ProductDetailPageResponse(product, imageUrl, reviewRate);
    }
}
