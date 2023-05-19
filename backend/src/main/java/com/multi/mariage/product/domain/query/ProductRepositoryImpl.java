package com.multi.mariage.product.domain.query;

import com.multi.mariage.product.domain.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.multi.mariage.product.domain.QProduct.product;
import static com.multi.mariage.review.domain.QReview.review;
import static com.multi.mariage.storage.domain.QImage.image;

public class ProductRepositoryImpl implements ProductRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ProductRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return queryFactory.selectFrom(product)
                .where(product.name.value.contains(name))
                .fetch();
    }

    /* https://velog.io/@cksdnr066/WARN-firstResultmaxResults-specified-with-collection-fetch-applying-in-memory */
    @Override
    public List<Product> findTotal() {
        List<Long> productIds = queryFactory.select(product.id)
                .from(product)
                .orderBy(product.reviews.size().desc())
                .offset(0)
                .limit(25)
                .fetch();

        return queryFactory.selectFrom(product)
                .join(product.image, image).fetchJoin()
                .join(product.reviews, review).fetchJoin()
                .where(product.id.in(productIds))
                .orderBy(product.name.value.asc())
                .fetch();
    }
}
