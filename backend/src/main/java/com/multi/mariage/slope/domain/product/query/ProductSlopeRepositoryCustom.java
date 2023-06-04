package com.multi.mariage.slope.domain.product.query;

import com.multi.mariage.slope.domain.product.ProductSlope;

import java.util.List;
import java.util.Optional;

public interface ProductSlopeRepositoryCustom {
    Optional<ProductSlope> findByProductIds(Long thisProductId, Long otherProductId);

    /**
     * 사용자가 작성하지 않은 제품들을 조회
     * thisProduct -> 사용자가 작성하지 않은 제품들을 조회 - notIn 절
     * targetProduct -> 사용자가 작성한 제품의 식별 번호 - in 절
     * order by -> thisProduct.id
     *
     * @param productIds 사용자가 작성한 제품 식별 번호들
     * @return ProductSlope 리스트
     */
    List<ProductSlope> findAllByMemberReviewProductIds(List<Long> productIds);
}
