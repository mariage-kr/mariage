package com.multi.mariage.category.vo.lowercategory;

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
    public static DrinkLowerSubCategoriesVO from(String name, String value) {
        return DrinkLowerSubCategoriesVO.builder()
                .name(name)
                .value(value)
                .build();
    }
}
