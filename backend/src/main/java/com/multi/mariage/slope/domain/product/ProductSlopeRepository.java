package com.multi.mariage.slope.domain.product;

import com.multi.mariage.slope.domain.product.query.ProductSlopeRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSlopeRepository extends JpaRepository<ProductSlope, Long>, ProductSlopeRepositoryCustom {
}
