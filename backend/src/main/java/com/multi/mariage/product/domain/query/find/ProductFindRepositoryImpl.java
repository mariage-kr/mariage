package com.multi.mariage.product.domain.query.find;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

public class ProductFindRepositoryImpl implements ProductFindRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ProductFindRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
