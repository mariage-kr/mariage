package com.multi.mariage.common.fixture;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.product.dto.request.ProductSaveRequest;

public enum ProductFixture {
    PRODUCT_MAKGEOLLI("느린마을 막걸리", 20, "쌀로 만든 술입니다.", Country.KOREA, DrinkUpperCategory.LOCAL_TRADITIONAL, DrinkLowerCategory.MAKGEOLLI);
    private String name;    // 제품 이름: 글자수 제한
    private double level;   // 제품 도수
    private String info;    // 제품 설명: 150자 제한
    private Country country;     // 제품 제조국
    private DrinkUpperCategory upperCategory;   // 제품 상위 카테고리
    private DrinkLowerCategory lowerCategory;   // 제품 하위 카테고리
//    private Long imageId;     // 제품 이미지

    ProductFixture(String name, double level, String info, Country country, DrinkUpperCategory upperCategory, DrinkLowerCategory lowerCategory) {
        this.name = name;
        this.level = level;
        this.info = info;
        this.country = country;
        this.upperCategory = upperCategory;
        this.lowerCategory = lowerCategory;
//        this.imageId = imageId;
    }

    public ProductSaveRequest toRegisterRequest() {
        return ProductSaveRequest.builder()
                .name(name)
                .level(level)
                .info(info)
                .country(country)
                .upperCategory(upperCategory)
                .lowerCategory(lowerCategory)
//                .image(image)
                .build();
    }
}
