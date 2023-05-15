package com.multi.mariage.category.vo.drink_lower;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkLowerSubCategoriesVO {

    private String name;
    private DrinkLowerCategory value;

    @Builder
    private DrinkLowerSubCategoriesVO(DrinkLowerCategory category) {
        this.name = category.getName();
        this.value = category;
    }

    public static DrinkLowerSubCategoriesVO from(DrinkLowerCategory category) {
        return DrinkLowerSubCategoriesVO.builder()
                .category(category)
                .build();
    }
}
