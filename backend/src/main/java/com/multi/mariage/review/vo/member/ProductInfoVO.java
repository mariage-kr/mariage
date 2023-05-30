package com.multi.mariage.review.vo.member;

import com.multi.mariage.product.domain.Product;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductInfoVO {
    private Long id;
    private Long imageId;
    private String imageUrl;
    private String name;
    private double level;
    private double reviewRate;
    private String info;
    private int countryId;
    private String country;

    private ProductInfoVO(Product product, String imageUrl, double reviewRate) {
        this.id = product.getId();
        this.imageId = product.getImage().getId();
        this.imageUrl = imageUrl;
        this.name = String.valueOf(product.getName());
        this.level = product.getLevel();
        this.reviewRate = reviewRate;
        this.info = String.valueOf(product.getInfo());
        this.countryId = product.getCountry().getId();
        this.country = product.getCountry().getValue();
    }

    public static ProductInfoVO from(Product product, String imageUrl, double reviewRate) {
        return new ProductInfoVO(product, imageUrl, reviewRate);
    }
}
