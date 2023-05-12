package com.multi.mariage.category.vo.drink_upper;

import com.multi.mariage.category.domain.DrinkUpperCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class DrinkUpperCategoriesVO {

    private String name;
    private DrinkUpperCategory value;

    @Builder
    private DrinkUpperCategoriesVO(String name, DrinkUpperCategory value) {
        this.name = name;
        this.value = value;
    }

    public static DrinkUpperCategoriesVO from(DrinkUpperCategory category) {
        return DrinkUpperCategoriesVO.builder()
                .name(category.getName())
                .value(category)
                .build();
    }
}
