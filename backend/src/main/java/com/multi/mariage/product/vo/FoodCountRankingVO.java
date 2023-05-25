package com.multi.mariage.product.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class FoodCountRankingVO {
    private int foodId;
    private String category;
    private int reviewCount;

    @Builder
    private FoodCountRankingVO(int foodId, String category, int reviewCount) {
        this.foodId = foodId;
        this.category = category;
        this.reviewCount = reviewCount;
    }

    public static FoodCountRankingVO from(int foodId, String category, int reviewCount) {
        return FoodCountRankingVO.builder()
                .foodId(foodId)
                .category(category)
                .reviewCount(reviewCount)
                .build();
    }
}
