package com.multi.mariage.product.domain.query.find;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.product.dto.condition.FilterCond;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ProductFindRepositoryImpl implements ProductFindRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ProductFindRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Product> findProducts(FilterCond cond) {
        return null;
    }
}
