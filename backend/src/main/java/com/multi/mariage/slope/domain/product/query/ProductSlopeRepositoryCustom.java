package com.multi.mariage.slope.domain.product.query;

import com.multi.mariage.slope.domain.product.ProductSlope;

import java.util.List;
import java.util.Optional;

public interface ProductSlopeRepositoryCustom {
    Optional<ProductSlope> findByProductIds(Long thisProductId, Long otherProductId);
}
