package com.multi.mariage.product.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewRankCountVO {
    private List<FoodCountRankingVO> countRanking;

    public ProductReviewRankCountVO(List<FoodCountRankingVO> countRanking) {
        this.countRanking = countRanking;
    }

    public static ProductReviewRankCountVO from(List<FoodCountRankingVO> countRanking) {
        return new ProductReviewRankCountVO(countRanking);
    }
}
