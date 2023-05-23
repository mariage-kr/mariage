package com.multi.mariage.product.vo.filter;

import com.multi.mariage.product.domain.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductFilterVO {
    private Long id;
    private String name;
    private String imageUrl;
    private double level;
    private ProductCountryFilterVO country;
    private ProductReviewFilterVO review;

    @Builder
    private ProductFilterVO(Long id, String name, String imageUrl, double level, ProductCountryFilterVO country,
                      ProductReviewFilterVO review) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.level = level;
        this.country = country;
        this.review = review;
    }

    public static ProductFilterVO from(Product product, String imageUrl,
                                 ProductCountryFilterVO country,
                                 ProductReviewFilterVO review) {
        return ProductFilterVO.builder()
                .id(product.getId())
                .name(product.getName())
                .imageUrl(imageUrl)
                .level(product.getLevel())
                .country(country)
                .review(review)
                .build();
    }
}
