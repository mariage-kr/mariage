package com.multi.mariage.product.vo;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.product.domain.Product;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductsVO {
    private Long id;
    private String name;
    private double level;
    private String info;
    private String upperCategory;
    private String lowerCategory;
    private String country;
    private Long imageId;
    private String imageUrl;

    @Builder
    private ProductsVO(Long id, String name, double level, String info, String upperCategory, String lowerCategory, String country, Long imageId, String imageUrl) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.info = info;
        this.upperCategory = upperCategory;
        this.lowerCategory = lowerCategory;
        this.country = country;
        this.imageId = imageId;
        this.imageUrl = imageUrl;
    }

    public static ProductsVO from(Product product, DrinkUpperCategory upperCategory, DrinkLowerCategory lowerCategory, Country country, String imageUrl) {
        return ProductsVO.builder()
                .id(product.getId())
                .name(product.getName())
                .level(product.getLevel().getValue())
                .info(product.getInfo())
                .upperCategory(upperCategory.getName())
                .lowerCategory(lowerCategory.getName())
                .country(country.getCountry())
                .imageId(product.getImage().getId())
                .imageUrl(imageUrl)
                .build();
    }
}
