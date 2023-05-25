package com.multi.mariage.product.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewRankRateVO {
    private List<FoodRateVO> rateRanking;

    public ProductReviewRankRateVO(List<FoodRateVO> rateRanking) {
        this.rateRanking = rateRanking;
    }

    public static ProductReviewRankRateVO from(List<FoodRateVO> rateRanking) {
        return new ProductReviewRankRateVO(rateRanking);
    }
}
