package com.multi.mariage.product.vo.filter;

import com.multi.mariage.category.domain.Food;
import com.multi.mariage.category.domain.FoodCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductFoodFilterVO {
    private int id;
    private String name;

    @Builder
    private ProductFoodFilterVO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ProductFoodFilterVO from(Food food) {
        FoodCategory category = food.getFoodCategory();
        return ProductFoodFilterVO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
