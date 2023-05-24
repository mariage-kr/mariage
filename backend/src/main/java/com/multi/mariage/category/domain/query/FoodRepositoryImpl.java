package com.multi.mariage.category.domain.query;

import com.multi.mariage.category.domain.Food;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.multi.mariage.category.domain.QFood.food;
import static com.multi.mariage.product.domain.QProduct.product;
import static com.querydsl.core.types.ExpressionUtils.count;

public class FoodRepositoryImpl implements FoodRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public FoodRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Food> findByProductId(Long productId, int size) {
        return queryFactory.selectFrom(food)
                .where(product.id.eq(productId))
                .join(food.product, product).fetchJoin()
                .orderBy(food.avgFoodRate.desc())
                .limit(size)
                .fetch();
    }
    @Override
    public List<Food> findByReviewCount(Long productId, int size) {
        return queryFactory.selectFrom(food)
                .where(product.id.eq(productId))
                .join(food.product, product).fetchJoin()
                .orderBy(food.reviews.size().desc())
                .limit(size)
                .fetch();
    }
}
