package com.multi.mariage.product.dto.response.temp;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.vo.FoodRateRankingVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewRankRateResponse {
    private Long productId;
    private List<FoodRateRankingVO> rateRanking;

    @Builder
    public ProductReviewRankRateResponse(Product product, List<FoodRateRankingVO> rateRanking) {
        this.productId = product.getId();
        this.rateRanking = rateRanking;
    }

    public static ProductReviewRankRateResponse from(Product product, List<FoodRateRankingVO> rateRanking) {
        return new ProductReviewRankRateResponse(product, rateRanking);
    }
}
