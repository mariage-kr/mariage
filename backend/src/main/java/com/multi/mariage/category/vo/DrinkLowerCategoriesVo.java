package com.multi.mariage.category.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkLowerCategoriesVo {
    private String name;
    private String value;
    private List<DrinkLowerCategoriesSubCategoriesVo> subCategories;

    @Builder
    private DrinkLowerCategoriesVo(String name, String value, List<DrinkLowerCategoriesSubCategoriesVo> subCategories) {
        this.name = name;
        this.value = value;
        this.subCategories = subCategories;
    }

    public static DrinkLowerCategoriesVo from(String name, String value, List<DrinkLowerCategoriesSubCategoriesVo> subCategories){
        return DrinkLowerCategoriesVo.builder()
                .name(name)
                .value(value)
                .subCategories(subCategories)
                .build();
    }
}
