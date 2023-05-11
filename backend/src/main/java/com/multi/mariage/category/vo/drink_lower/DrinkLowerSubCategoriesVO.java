package com.multi.mariage.category.vo.drinkLower;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkLowerSubCategoriesVO {

    private String name;
    private String value;

    @Builder
    private DrinkLowerSubCategoriesVO(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static DrinkLowerSubCategoriesVO from(DrinkLowerCategory category) {
        return DrinkLowerSubCategoriesVO.builder()
                .name(category.name())
                .value(category.getName())
                .build();
    }
}
