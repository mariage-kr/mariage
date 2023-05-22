package com.multi.mariage.review.vo.product;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewFoodVO {
    private int id; // 음식 카테고리 고유 식별자
    private String name;
    private int rate;

    @Builder
    public ProductReviewFoodVO(int id, String name, int rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }
}
