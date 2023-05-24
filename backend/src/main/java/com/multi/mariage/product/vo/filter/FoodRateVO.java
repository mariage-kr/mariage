package com.multi.mariage.product.vo.filter;

import com.multi.mariage.category.domain.FoodCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class FoodRateVO {
    private int id;
    private String category;
    private double avgFoodRate;

    @Builder
    private FoodRateVO(int id, String category, double avgFoodRate) {
        this.id = id;
        this.category = category;
        this.avgFoodRate = avgFoodRate;
    }

    public static FoodRateVO from(int id, String category, double avgFoodRate) {
        return FoodRateVO.builder()
                .id(id)
                .category(category)
                .avgFoodRate(avgFoodRate)
                .build();
    }
}
