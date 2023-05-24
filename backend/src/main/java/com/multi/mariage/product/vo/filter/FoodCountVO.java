package com.multi.mariage.product.vo.filter;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class FoodCountVO {
    private int id;
    private String category;
    private int reviewCount;

    @Builder
    private FoodCountVO(int id, String category, int reviewCount) {
        this.id = id;
        this.category = category;
        this.reviewCount = reviewCount;
    }

    public static FoodCountVO from(int id, String category, int reviewCount) {
        return FoodCountVO.builder()
                .id(id)
                .category(category)
                .reviewCount(reviewCount)
                .build();
    }
}
