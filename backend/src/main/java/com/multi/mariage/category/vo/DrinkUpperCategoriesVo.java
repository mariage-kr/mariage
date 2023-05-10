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
    public DrinkUpperCategoriesVo(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
