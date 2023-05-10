package com.multi.mariage.category.vo.drinkupper;

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

    public static DrinkUpperCategoriesVO from(String name, String value) {
        return DrinkUpperCategoriesVO.builder()
                .name(name)
                .value(value)
                .build();
    }
}
