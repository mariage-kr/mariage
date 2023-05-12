package com.multi.mariage.category.vo.food;

import com.multi.mariage.category.domain.FoodCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class FoodCategoriesVO {
    private int id;
    private String name;
    private FoodCategory value;

    @Builder
    private FoodCategoriesVO(int id, String name, FoodCategory value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public static FoodCategoriesVO from(FoodCategory category) {
        return FoodCategoriesVO.builder()
                .id(category.getId())
                .name(category.getName())
                .value(category)
                .build();
    }
}
