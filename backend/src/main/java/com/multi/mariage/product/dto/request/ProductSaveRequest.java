package com.multi.mariage.product.dto.request;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.country.domain.Country;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductSaveRequest {

    private String name;    // 제품 이름: 글자수 제한
    private double level;   // 제품 도수
    private String info;    // 제품 설명: 150자 제한
    private Country country;     // 제품 제조국
    private DrinkUpperCategory upperCategory;   // 제품 상위 카테고리
    private DrinkLowerCategory lowerCategory;   // 제품 하위 카테고리
    private Long imageId;     // 제품 이미지

    @Builder
    private ProductSaveRequest(String name, double level, String info, Country country, DrinkUpperCategory upperCategory, DrinkLowerCategory lowerCategory, Long imageId) {
        this.name = name;
        this.level = level;
        this.info = info;
        this.country = country;
        this.upperCategory = upperCategory;
        this.lowerCategory = lowerCategory;
        this.imageId = imageId;
    }
}
