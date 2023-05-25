package com.multi.mariage.product.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class FoodCountVO {
    private int foodId;
    private String category;
    private int reviewCount;

    @Builder
    private FoodCountVO(int foodId, String category, int reviewCount) {
        this.foodId = foodId;
        this.category = category;
        this.reviewCount = reviewCount;
    }

    public static FoodCountVO from(int foodId, String category, int reviewCount) {
        return FoodCountVO.builder()
                .foodId(foodId)
                .category(category)
                .reviewCount(reviewCount)
                .build();
    }
}
