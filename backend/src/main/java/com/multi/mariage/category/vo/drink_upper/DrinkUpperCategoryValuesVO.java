package com.multi.mariage.category.vo.drink_upper;

import com.multi.mariage.category.domain.Region;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkUpperCategoryValuesVO {

    private String region;
    private String regionValue;
    private List<DrinkUpperCategoriesVO> categories;

    @Builder
    private DrinkUpperCategoryValuesVO(String region, String regionValue, List<DrinkUpperCategoriesVO> categories) {
        this.region = region;
        this.regionValue = regionValue;
        this.categories = categories;
    }

    public static DrinkUpperCategoryValuesVO from(Region region, List<DrinkUpperCategoriesVO> categories) {
        return DrinkUpperCategoryValuesVO.builder()
                .region(region.getValue())
                .regionValue(region.name())
                .categories(categories)
                .build();
    }
}
