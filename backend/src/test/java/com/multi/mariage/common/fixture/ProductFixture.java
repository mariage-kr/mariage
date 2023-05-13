package com.multi.mariage.common.fixture;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.product.dto.request.ProductSaveRequest;

public enum ProductFixture {
    PRODUCT_MAKGEOLLI("느린마을 막걸리", 20, "쌀로 만든 술입니다.", Country.KOREA, DrinkUpperCategory.LOCAL_TRADITIONAL, DrinkLowerCategory.MAKGEOLLI);
    private String name;
    private double level;
    private String info;
    private Country country;
    private DrinkUpperCategory upperCategory;
    private DrinkLowerCategory lowerCategory;

    ProductFixture(String name, double level, String info, Country country, DrinkUpperCategory upperCategory, DrinkLowerCategory lowerCategory) {
        this.name = name;
        this.level = level;
        this.info = info;
        this.country = country;
        this.upperCategory = upperCategory;
        this.lowerCategory = lowerCategory;
    }

    public ProductSaveRequest toRegisterRequest() {
        return ProductSaveRequest.builder()
                .name(name)
                .level(level)
                .info(info)
                .country(country)
                .upperCategory(upperCategory)
                .lowerCategory(lowerCategory)
                .build();
    }
}
