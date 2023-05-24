package com.multi.mariage.product.dto.response;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.vo.filter.FoodCountVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewRankCountResponse {
    private Long productId;
    private List<FoodCountVO> countRanking;

    @Builder
    public ProductReviewRankCountResponse(Product product, List<FoodCountVO> countRanking) {
        this.productId = product.getId();
        this.countRanking = countRanking;
    }

    public static ProductReviewRankCountResponse from(Product product, List<FoodCountVO> countRanking) {
        return new ProductReviewRankCountResponse(product, countRanking);
    }
}
