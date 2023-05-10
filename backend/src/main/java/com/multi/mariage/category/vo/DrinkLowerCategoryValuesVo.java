package com.multi.mariage.category.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkLowerCategoryValuesVo {

    private String region;
    private String regionValue;
    private List<DrinkLowerCategoriesVo> categories;

    @Builder
    private DrinkLowerCategoryValuesVo(String region, String regionValue, List<DrinkLowerCategoriesVo> categories) {
        this.region = region;
        this.regionValue = regionValue;
        this.categories = categories;
    }
public static DrinkLowerCategoryValuesVo from(String region, String regionValue, List<DrinkLowerCategoriesVo> categories) {
    return DrinkLowerCategoryValuesVo.builder()
            .region(region)
            .regionValue(regionValue)
            .categories(categories)
            .build();
}

}
