package com.multi.mariage.product.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewRankCountVO {
    private List<FoodCountVO> countRanking;

    public ProductReviewRankCountVO(List<FoodCountVO> countRanking) {
        this.countRanking = countRanking;
    }

    public static ProductReviewRankCountVO from(List<FoodCountVO> countRanking) {
        return new ProductReviewRankCountVO(countRanking);
    }
}
