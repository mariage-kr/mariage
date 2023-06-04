package com.multi.mariage.slope.domain.product.query;

import com.multi.mariage.slope.domain.product.ProductSlope;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import static com.multi.mariage.product.domain.QProduct.product;
import static com.multi.mariage.slope.domain.product.QProductSlope.productSlope;

public class ProductSlopeRepositoryImpl implements ProductSlopeRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ProductSlopeRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Optional<ProductSlope> findByProductIds(Long thisProductId, Long targetProductId) {
        ProductSlope slope = queryFactory.selectFrom(productSlope)
                .join(productSlope.thisProduct, product)
                .where(productSlope.thisProduct.id.eq(thisProductId))
                .where(productSlope.targetProduct.id.eq(targetProductId))
                .fetchFirst();

        return Optional.ofNullable(slope);
    }

    @Override
    public List<ProductSlope> findAllByMemberReviewProductIds(List<Long> productIds) {
        return queryFactory.selectFrom(productSlope)
                .where(productSlope.thisProduct.id.notIn(productIds))
                .where(productSlope.targetProduct.id.in(productIds))
                .orderBy(productSlope.thisProduct.id.asc())
                .fetch();
    }
}
