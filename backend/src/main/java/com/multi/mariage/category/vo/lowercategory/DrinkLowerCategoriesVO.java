package com.multi.mariage.category.vo.lowercategory;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkLowerCategoriesVO {
    private String name;
    private String value;
    private List<DrinkLowerSubCategoriesVO> subCategories;

    @Builder
    private DrinkLowerCategoriesVO(String name, String value, List<DrinkLowerSubCategoriesVO> subCategories) {
        this.name = name;
        this.value = value;
        this.subCategories = subCategories;
    }

    public static DrinkLowerCategoriesVO from(String name, String value, List<DrinkLowerSubCategoriesVO> subCategories){
        return DrinkLowerCategoriesVO.builder()
                .name(name)
                .value(value)
                .subCategories(subCategories)
                .build();
    }
}
