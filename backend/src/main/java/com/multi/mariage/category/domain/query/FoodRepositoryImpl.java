package com.multi.mariage.category.domain.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

public class FoodRepositoryImpl implements FoodRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public FoodRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
}
