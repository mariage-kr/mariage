package com.multi.mariage.product.domain.query;

import com.multi.mariage.product.domain.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.multi.mariage.product.domain.QProduct.product;

public class ProductRepositoryImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ProductRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return queryFactory.selectFrom(product)
                .where(product.name.like(name))
                .fetch();
    }
}
