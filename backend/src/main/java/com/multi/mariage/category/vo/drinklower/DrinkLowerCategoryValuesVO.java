package com.multi.mariage.category.vo.drinklower;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkLowerCategoryValuesVO {

    private String region;
    private String regionValue;
    private List<DrinkLowerCategoriesVO> categories;

    @Builder
    private DrinkLowerCategoryValuesVO(String region, String regionValue, List<DrinkLowerCategoriesVO> categories) {
        this.region = region;
        this.regionValue = regionValue;
        this.categories = categories;
    }
public static DrinkLowerCategoryValuesVO from(String region, String regionValue, List<DrinkLowerCategoriesVO> categories) {
    return DrinkLowerCategoryValuesVO.builder()
            .region(region)
            .regionValue(regionValue)
            .categories(categories)
            .build();
}

}
