package com.multi.mariage.category.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkLowerCategoriesSubCategoriesVo {

    private String name;
    private String value;

    @Builder
    private DrinkLowerCategoriesSubCategoriesVo(String name, String value) {
        this.name = name;
        this.value = value;
    }
    public static DrinkLowerCategoriesSubCategoriesVo from(String name, String value) {
        return DrinkLowerCategoriesSubCategoriesVo.builder()
                .name(name)
                .value(value)
                .build();
    }
}
