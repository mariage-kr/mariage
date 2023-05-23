package com.multi.mariage.product.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class FoodCountsVO {
    private String food;
    private int count;

    private FoodCountsVO(String food, int count) {
        this.food = food;
        this.count = count;
    }

    public static FoodCountsVO from(String food, int count) {

        return new FoodCountsVO(food, count);
    }
}
