package com.multi.mariage.product.dto.response;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.vo.filter.FoodRateVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewRankRateResponse {
    private Long productId;
    private List<FoodRateVO> rateRanking;

    @Builder
    public ProductReviewRankRateResponse(Product product, List<FoodRateVO> rateRanking) {
        this.productId = product.getId();
        this.rateRanking = rateRanking;
    }

    public static ProductReviewRankRateResponse from(Product product, List<FoodRateVO> rateRanking) {
        return new ProductReviewRankRateResponse(product, rateRanking);
    }
}
