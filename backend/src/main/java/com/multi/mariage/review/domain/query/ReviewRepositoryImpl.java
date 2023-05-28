package com.multi.mariage.review.domain.query;

import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.Sort;
import com.multi.mariage.review.dto.MemberReviewsPagingCond;
import com.multi.mariage.review.dto.ReviewsPagingCond;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.multi.mariage.hashtag.domain.QHashtag.hashtag;
import static com.multi.mariage.like.domain.QLike.like;
import static com.multi.mariage.member.domain.QMember.member;
import static com.multi.mariage.product.domain.QProduct.product;
import static com.multi.mariage.review.domain.QReview.review;
import static com.multi.mariage.review.domain.QReviewHashtag.reviewHashtag;
import static com.multi.mariage.storage.domain.QImage.image;
import static com.multi.mariage.weather.domain.QWeather.weather;

public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public ReviewRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Review> findReviewsByProductId(ReviewsPagingCond cond) {
        List<Long> reviewIds = getPagingReviewIds(cond);

        return queryFactory.selectFrom(review)
                .join(review.weather, weather).fetchJoin()
                .join(review.member, member).fetchJoin()
                .leftJoin(review.image, image).fetchJoin()
                .leftJoin(review.likes, like).fetchJoin()
                .leftJoin(review.reviewHashtags, reviewHashtag).fetchJoin()
                .leftJoin(reviewHashtag.hashtag, hashtag).fetchJoin()
                .where(review.id.in(reviewIds))
                .orderBy(review.id.desc())
                .fetch();
    }

    @Override
    public List<Review> findReviewsByMemberId(MemberReviewsPagingCond cond) {
        List<Long> reviewIds = getPagingReviewsByMember(cond);

        return queryFactory.selectFrom(review)
                .join(review.member, member).fetchJoin()
                .join(review.product, product).fetchJoin()
                .leftJoin(review.image, image).fetchJoin()
                .leftJoin(review.likes, like).fetchJoin()
                .leftJoin(review.reviewHashtags, reviewHashtag).fetchJoin()
                .leftJoin(reviewHashtag.hashtag, hashtag).fetchJoin()
                .orderBy(review.id.desc())
                .where(review.id.in(reviewIds))
                .fetch();
    }

    private List<Long> getPagingReviewIds(ReviewsPagingCond cond) {
        JPAQuery<Long> reviewIdsQuery = queryFactory.select(review.id)
                .from(review)
                .where(review.product.id.eq(cond.getProductId()))
                .offset(getOffset(cond))
                .limit(cond.getPageSize());

        OrderSpecifier<Integer> sortOption = sortOption(cond.getSort());
        if (sortOption != null) {
            reviewIdsQuery = reviewIdsQuery.orderBy(sortOption);
        }

        return reviewIdsQuery.fetch();
    }

    private List<Long> getPagingReviewsByMember(MemberReviewsPagingCond cond) {
        JPAQuery<Long> reviewIdsQuery = queryFactory.select(review.id)
                .from(review)
                .where(review.member.id.eq(cond.getMemberId()))
                .orderBy(review.id.desc())
                .offset((long) (cond.getPageNumber() - 1) * cond.getPageSize())
                .limit(cond.getPageSize());

        OrderSpecifier<Integer> sortOption = sortOption(cond.getSort());
        if (sortOption != null) {
            reviewIdsQuery = reviewIdsQuery.orderBy(sortOption);
        }

        return reviewIdsQuery.fetch();
    }

    private OrderSpecifier<Integer> sortOption(String sort) {
        return sort.toUpperCase().equals(Sort.LIKED.name()) ? review.likes.size().desc() : null;
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

    @Override
    public Long findReviewsCountByMemberId(Long memberId) {
        JPAQuery<Long> countQuery = queryFactory.select(review.count())
                .from(review)
                .where(review.member.id.eq(memberId));

        return countQuery.fetchFirst();
    }
}
