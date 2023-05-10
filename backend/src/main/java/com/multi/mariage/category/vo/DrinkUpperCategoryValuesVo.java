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
    public DrinkUpperCategoryValuesVo(String region, String regionValue, List<DrinkUpperCategoriesVo> categories) {
        this.region = region;
        this.regionValue = regionValue;
        this.categories = categories;
    }
}
