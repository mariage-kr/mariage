package com.multi.mariage.product.vo;

import com.multi.mariage.product.domain.Product;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewStatsVO {
    private double reviewAverageRate;
    private int reviewCount;
    private List<ReviewRateVO> percentageList;

    public ProductReviewStatsVO(double reviewAverageRate, int reviewCount, List<ReviewRateVO> percentageList) {
        this.reviewAverageRate = reviewAverageRate;
        this.reviewCount = reviewCount;
        this.percentageList = percentageList;
    }

    public static ProductReviewStatsVO from(Product product, List<ReviewRateVO> percentageList) {
        return new ProductReviewStatsVO(product.getAvgReviewRate(), product.getReviews().size(), percentageList);
    }
}
