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
public class ProductReviewRankCountResponse {
    private Long productId;
    private List<FoodRateVO> rateRanking;

    @Builder
    public ProductReviewRankCountResponse(Product product, List<FoodRateVO> rateRanking) {
        this.productId = product.getId();
        this.rateRanking = rateRanking;
    }

    public static ProductReviewRankCountResponse from(Product product, List<FoodRateVO> rateRanking) {
        return new ProductReviewRankCountResponse(product, rateRanking);
    }
}
