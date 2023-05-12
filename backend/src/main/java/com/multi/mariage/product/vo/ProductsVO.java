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
    private int id;
    private String name;
    private double level;
    private String info;
    private String upperCategory;
    private String lowerCategory;
    private String country;
    private Long image;

    @Builder
    private ProductsVO(int id, String name, double level, String info, String upperCategory, String lowerCategory, String country, Long image) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.info = info;
        this.upperCategory = upperCategory;
        this.lowerCategory = lowerCategory;
        this.country = country;
        this.image = image;
    }


    public static ProductsVO from(Product product, DrinkUpperCategory upperCategory, DrinkLowerCategory lowerCategory, Country country) {
        return ProductsVO.builder()
                .name(product.getName())
                .level(product.getLevel())
                .info(product.getInfo())
                .upperCategory(upperCategory.getName())
                .lowerCategory(lowerCategory.getName())
                .country(country.getCountry())
                .build();
    }
}
