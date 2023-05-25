package com.multi.mariage.product.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class FoodRateVO {
    private int foodId;
    private String category;
    private double avgFoodRate;

    @Builder
    private FoodRateVO(int foodId, String category, double avgFoodRate) {
        this.foodId = foodId;
        this.category = category;
        this.avgFoodRate = avgFoodRate;
    }

    public static FoodRateVO from(int foodId, String category, double avgFoodRate) {
        return FoodRateVO.builder()
                .foodId(foodId)
                .category(category)
                .avgFoodRate(avgFoodRate)
                .build();
    }
}
