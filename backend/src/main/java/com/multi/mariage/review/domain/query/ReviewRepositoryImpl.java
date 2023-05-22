package com.multi.mariage.review.domain.query;

import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.dto.ReviewsPagingCond;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.multi.mariage.review.domain.QReview.review;

public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ReviewRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Review> findReviewByProductId(ReviewsPagingCond cond) {
        return queryFactory.selectFrom(review)
                .where(review.product.id.eq(cond.getProductId()))
                .offset((long) cond.getPageNumber() * cond.getPageSize())
                .limit(cond.getPageSize())
                .fetch();
    }
}
