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
    private Region value;
    private List<DrinkUpperCategoriesVO> categories;

    @Builder
    private DrinkUpperCategoryValuesVO(Region region, List<DrinkUpperCategoriesVO> categories) {
        this.region = region.getValue();
        this.value = region;
        this.categories = categories;
    }

    public static DrinkUpperCategoryValuesVO from(Region region, List<DrinkUpperCategoriesVO> categories) {
        return DrinkUpperCategoryValuesVO.builder()
                .region(region)
                .categories(categories)
                .build();
    }
}
