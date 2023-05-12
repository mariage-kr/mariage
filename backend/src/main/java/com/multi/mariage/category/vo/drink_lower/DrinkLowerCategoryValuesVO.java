package com.multi.mariage.category.vo.drink_lower;

import com.multi.mariage.category.domain.Region;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkLowerCategoryValuesVO {

    private String region;
    private Region value;
    private List<DrinkLowerCategoriesVO> categories;

    @Builder
    private DrinkLowerCategoryValuesVO(Region region, List<DrinkLowerCategoriesVO> categories) {
        this.region = region.getValue();
        this.value = region;
        this.categories = categories;
    }

    public static DrinkLowerCategoryValuesVO from(Region region, List<DrinkLowerCategoriesVO> categories) {
        return DrinkLowerCategoryValuesVO.builder()
                .region(region)
                .categories(categories)
                .build();
    }
}
