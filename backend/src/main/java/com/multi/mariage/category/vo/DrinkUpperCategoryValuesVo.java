package com.multi.mariage.category.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkUpperCategoryValuesVo {

    private String region;
    private String regionValue;
    private List<DrinkUpperCategoriesVo> categories;

    @Builder
    private DrinkUpperCategoryValuesVo(String region, String regionValue, List<DrinkUpperCategoriesVo> categories) {
        this.region = region;
        this.regionValue = regionValue;
        this.categories = categories;
    }

    public static DrinkUpperCategoryValuesVo from(String region, String regionValue, List<DrinkUpperCategoriesVo> categories) {
        return DrinkUpperCategoryValuesVo.builder()
                .region(region)
                .regionValue(regionValue)
                .categories(categories)
                .build();
    }
}
