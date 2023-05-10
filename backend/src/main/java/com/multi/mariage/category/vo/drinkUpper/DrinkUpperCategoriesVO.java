package com.multi.mariage.category.vo.drinkUpper;

import com.multi.mariage.category.domain.DrinkUpperCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkUpperCategoriesVO {

    private String name;
    private String value;

    @Builder
    private DrinkUpperCategoriesVO(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static DrinkUpperCategoriesVO from(DrinkUpperCategory category) {
        return DrinkUpperCategoriesVO.builder()
                .name(category.name())
                .value(category.getName())
                .build();
    }
}
