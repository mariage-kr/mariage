package com.multi.mariage.category.vo.food;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class FoodCategoriesVO {
    private int id;
    private String name;

    @Builder
    public FoodCategoriesVO(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
