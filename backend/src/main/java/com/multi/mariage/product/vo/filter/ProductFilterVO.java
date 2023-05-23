package com.multi.mariage.product.vo.filter;

import lombok.Builder;

public class ProductFilterVO {
    private Long id;
    private String name;
    private String imageUrl;
    private double level;
    private ProductCountryFilterVO country;
    private ProductReviewFilterVO review;

    @Builder
    public ProductFilterVO(Long id, String name, String imageUrl, double level, ProductCountryFilterVO country, ProductReviewFilterVO review) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.level = level;
        this.country = country;
        this.review = review;
    }
}
