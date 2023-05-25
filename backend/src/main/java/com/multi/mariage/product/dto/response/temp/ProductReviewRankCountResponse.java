package com.multi.mariage.product.dto.response.temp;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.vo.FoodCountRankingVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewRankCountResponse {
    private Long productId;
    private List<FoodCountRankingVO> countRanking;

    @Builder
    public ProductReviewRankCountResponse(Product product, List<FoodCountRankingVO> countRanking) {
        this.productId = product.getId();
        this.countRanking = countRanking;
    }

    public static ProductReviewRankCountResponse from(Product product, List<FoodCountRankingVO> countRanking) {
        return new ProductReviewRankCountResponse(product, countRanking);
    }
}
