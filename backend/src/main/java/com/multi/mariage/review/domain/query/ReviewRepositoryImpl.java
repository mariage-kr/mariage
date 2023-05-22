package com.multi.mariage.review.domain.query;

import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.dto.ReviewsPagingCond;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.multi.mariage.like.domain.QLike.like;
import static com.multi.mariage.member.domain.QMember.member;
import static com.multi.mariage.review.domain.QReview.review;
import static com.multi.mariage.storage.domain.QImage.image;
import static com.multi.mariage.weather.domain.QWeather.weather;

public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ReviewRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Review> findReviewsByProductId(ReviewsPagingCond cond) {
        List<Long> reviewIds = queryFactory.select(review.id)
                .from(review)
                .where(review.product.id.eq(cond.getProductId()))
                .offset(getOffset(cond))
                .limit(cond.getPageSize())
                .fetch();

        return queryFactory.selectFrom(review)
                .join(review.weather, weather).fetchJoin()
                .join(review.member, member).fetchJoin()
                .leftJoin(review.image, image).fetchJoin()
                .leftJoin(review.likes, like).fetchJoin()
                .where(review.id.in(reviewIds))
                .fetch();
    }

    private long getOffset(ReviewsPagingCond cond) {
        return (long) (cond.getPageNumber() - 1) * cond.getPageSize();
    }

    @Override
    public Long findReviewsCountByProductId(Long productId) {
        JPAQuery<Long> countQuery = queryFactory.select(review.count())
                .from(review)
                .where(review.product.id.eq(productId));

        return countQuery.fetchFirst();
    }
}
