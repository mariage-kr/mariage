package com.multi.mariage.product.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewRankRateVO {
    private List<FoodRateRankingVO> rateRanking;

    public ProductReviewRankRateVO(List<FoodRateRankingVO> rateRanking) {
        this.rateRanking = rateRanking;
    }

    public static ProductReviewRankRateVO from(List<FoodRateRankingVO> rateRanking) {
        return new ProductReviewRankRateVO(rateRanking);
    }
}
