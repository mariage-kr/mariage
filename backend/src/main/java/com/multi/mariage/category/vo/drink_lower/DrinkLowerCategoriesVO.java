package com.multi.mariage.category.vo.drink_lower;

import com.multi.mariage.category.domain.DrinkUpperCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkLowerCategoriesVO {
    private String name;
    private DrinkUpperCategory value;
    private List<DrinkLowerSubCategoriesVO> subCategories;

    @Builder
    private DrinkLowerCategoriesVO(DrinkUpperCategory category, List<DrinkLowerSubCategoriesVO> subCategories) {
        this.name = category.getName();
        this.value = category;
        this.subCategories = subCategories;
    }

    public static DrinkLowerCategoriesVO from(DrinkUpperCategory category,
                                              List<DrinkLowerSubCategoriesVO> subCategories) {
        return DrinkLowerCategoriesVO.builder()
                .category(category)
                .subCategories(subCategories)
                .build();
    }
}
