package com.multi.mariage.product.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class FoodRateRankingVO {
    private int foodId;
    private String category;
    private double avgFoodRate;

    @Builder
    private FoodRateRankingVO(int foodId, String category, double avgFoodRate) {
        this.foodId = foodId;
        this.category = category;
        this.avgFoodRate = avgFoodRate;
    }

    public static FoodRateRankingVO from(int foodId, String category, double avgFoodRate) {
        return FoodRateRankingVO.builder()
                .foodId(foodId)
                .category(category)
                .avgFoodRate(avgFoodRate)
                .build();
    }
}
