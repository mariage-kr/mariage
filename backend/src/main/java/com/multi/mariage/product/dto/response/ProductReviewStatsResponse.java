package com.multi.mariage.product.dto.response;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.vo.ReviewRateVO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewStatsResponse {
    private Long productId;
    private double reviewAverageRate;
    private int reviewCount;
    private List<ReviewRateVO> percentageList;

    public ProductReviewStatsResponse(Product product, double reviewAverageRate, int reviewCount, List<ReviewRateVO> percentageList) {
        this.productId = product.getId();
        this.reviewAverageRate = reviewAverageRate;
        this.reviewCount = reviewCount;
        this.percentageList = percentageList;
    }

    public static ProductReviewStatsResponse from(Product product, List<ReviewRateVO> percentageList) {
        return new ProductReviewStatsResponse(product, product.getAvgReviewRate(), product.getReviews().size(),
                percentageList);
    }
}
