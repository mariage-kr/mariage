package com.multi.mariage.category.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkUpperCategoriesVo {

    private String name;
    private String value;

    @Builder
    private DrinkUpperCategoriesVo(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static DrinkUpperCategoriesVo from(String name, String value) {
        return DrinkUpperCategoriesVo.builder()
                .name(name)
                .value(value)
                .build();
    }
}
