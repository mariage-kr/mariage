package com.multi.mariage.review.domain.query;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.review.domain.QReview;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.Sort;
import com.multi.mariage.review.dto.cond.MemberReviewsPagingCond;
import com.multi.mariage.review.dto.cond.ReviewsPagingCond;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

import static com.multi.mariage.category.domain.QFood.food;
import static com.multi.mariage.hashtag.domain.QHashtag.hashtag;
import static com.multi.mariage.like.domain.QLike.like;
import static com.multi.mariage.member.domain.QMember.member;
import static com.multi.mariage.product.domain.QProduct.product;
import static com.multi.mariage.review.domain.QReview.review;
import static com.multi.mariage.review.domain.QReviewHashtag.reviewHashtag;
import static com.multi.mariage.storage.domain.QImage.image;
import static com.multi.mariage.weather.domain.QWeather.weather;

@Slf4j
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
                .where(hasCategory(cond.getFoodCategory()))
                .where(hasRate(cond.getRate()))
                .where(isNotReportReview())
                .orderBy(sortOption(cond.getSort()))
                .offset(getOffset(cond))
                .limit(cond.getPageSize())
                .fetch();

        return queryFactory.selectFrom(review)
                .join(review.weather, weather).fetchJoin()
                .join(review.member, member).fetchJoin()
                .leftJoin(review.foodCategory, food).fetchJoin()
                .leftJoin(review.likes, like).fetchJoin()
                .leftJoin(review.image, image).fetchJoin()
                .leftJoin(review.reviewHashtags, reviewHashtag).fetchJoin()
                .leftJoin(reviewHashtag.hashtag, hashtag).fetchJoin()
                .where(review.id.in(reviewIds))
                .orderBy(sortOption(cond.getSort()))
                .fetch();
    }

    private OrderSpecifier<?> sortOption(String sort) {
        if (sort.equalsIgnoreCase(Sort.LIKE.name())) {
            return review.likes.size().desc();
        }
        if (sort.equalsIgnoreCase(Sort.NEWEST.name())) {
            return review.id.desc();
        }
        return null;
    }

    @Override
    public Long findReviewsCountByProductId(Long productId, FoodCategory category, Integer rate) {
        return queryFactory.select(review.count())
                .from(review)
                .where(review.product.id.eq(productId))
                .where(hasCategory(category))
                .where(hasRate(rate))
                .where(isNotReportReview())
                .fetchFirst();
    }

    private BooleanExpression hasCategory(FoodCategory category) {
        return category != null ? review.foodCategory.category.eq(category) : null;
    }

    private BooleanExpression hasRate(Integer rate) {
        return rate != 0 ? review.productRate.eq(rate) : null;
    }

    @Override
    public List<Review> findRatedReviewsByMemberId(MemberReviewsPagingCond cond) {
        List<Long> reviewIds = getPagingReviewsByRatings(cond);

        return queryFactory.selectFrom(review)
                .join(review.member, member).fetchJoin()
                .join(review.product, product).fetchJoin()
                .leftJoin(review.image, image).fetchJoin()
                .leftJoin(review.likes, like).fetchJoin()
                .leftJoin(review.reviewHashtags, reviewHashtag).fetchJoin()
                .leftJoin(reviewHashtag.hashtag, hashtag).fetchJoin()
                .where(review.id.in(reviewIds))
                .orderBy(review.id.desc())
                .fetch();
    }

    private List<Long> getPagingReviewsByRatings(MemberReviewsPagingCond cond) {
        JPAQuery<Long> reviewIdsQuery = queryFactory.select(review.id)
                .from(review)
                .where(review.member.id.eq(cond.getMemberId()))
                .where(isNotReportReview())
                .orderBy(review.id.desc())
                .offset((long) (cond.getPageNumber() - 1) * cond.getPageSize())
                .limit(cond.getPageSize());

        return reviewIdsQuery.fetch();
    }

    @Override
    public List<Review> findLikedReviewsByMemberId(MemberReviewsPagingCond cond) {
        List<Long> reviewIds = getPagingReviewsByLikes(cond);

        return queryFactory.selectFrom(review)
                .join(review.likes, like).fetchJoin()
                .join(review.product, product).fetchJoin()
                .leftJoin(review.image, image).fetchJoin()
                .leftJoin(review.reviewHashtags, reviewHashtag).fetchJoin()
                .leftJoin(reviewHashtag.hashtag, hashtag).fetchJoin()
                .where(review.id.in(reviewIds))
                .orderBy(review.id.desc())
                .fetch();
    }

    private List<Long> getPagingReviewsByLikes(MemberReviewsPagingCond cond) {
        JPAQuery<Long> reviewIdsQuery = queryFactory.select(review.id)
                .from(review)
                .join(like)
                .where(review.eq(like.review))
                .where(like.member.id.eq(cond.getMemberId()))
                .where(isNotReportReview())
                .orderBy(like.review.id.desc())
                .offset((long) (cond.getPageNumber() - 1) * cond.getPageSize())
                .limit(cond.getPageSize());

        return reviewIdsQuery.fetch();
    }

    private long getOffset(ReviewsPagingCond cond) {
        return (long) (cond.getPageNumber() - 1) * cond.getPageSize();
    }

    @Override
    public Long findReviewsCountByRatings(Long memberId) {
        JPAQuery<Long> countQuery = queryFactory.select(review.count())
                .from(review)
                .where(review.member.id.eq(memberId))
                .where(isNotReportReview());

        return countQuery.fetchFirst();
    }

    @Override
    public Long findReviewsCountByLikes(Long memberId) {
        JPAQuery<Long> countQuery = queryFactory.select(review.count())
                .from(review)
                .join(like)
                .where(review.eq(like.review))
                .where(like.member.id.eq(memberId))
                .where(isNotReportReview());

        return countQuery.fetchFirst();
    }

    @Override
    public Optional<Review> findByIdToDelete(Long reviewId) {
        Review findReview = queryFactory.selectFrom(review)
                .join(review.member, member).fetchJoin()
                .join(review.product, product).fetchJoin()
                .join(review.weather, weather).fetchJoin()
                .leftJoin(member.likes, like).fetchJoin()
                .leftJoin(review.foodCategory, food).fetchJoin()
                .leftJoin(review.image, image).fetchJoin()
                .leftJoin(review.reviewHashtags, reviewHashtag).fetchJoin()
                .leftJoin(reviewHashtag.hashtag, hashtag).fetchJoin()
                .where(review.id.eq(reviewId))
                .fetchFirst();

        return Optional.ofNullable(findReview);
    }

    @Override
    public Optional<Review> findByIdToUpdate(Long reviewId) {
        Review review = queryFactory.selectFrom(QReview.review)
                .join(QReview.review.member, member).fetchJoin()
                .join(QReview.review.product, product).fetchJoin()
                .leftJoin(QReview.review.foodCategory, food).fetchJoin()
                .leftJoin(QReview.review.image, image).fetchJoin()
                .leftJoin(QReview.review.reviewHashtags, reviewHashtag).fetchJoin()
                .leftJoin(reviewHashtag.hashtag, hashtag).fetchJoin()
                .where(QReview.review.id.eq(reviewId))
                .fetchOne();

        return Optional.ofNullable(review);
    }

    private BooleanExpression isNotReportReview() {
        return review.report.eq(false);
    }

    @Override
    public List<Review> findAllByMemberIdAndProductId(Long memberId, Long productId) {
        List<Long> reviewIds = queryFactory.select(review.id)
                .from(review)
                .join(review.member, member)
                .join(review.product, product)
                .where(review.member.id.eq(memberId))
                .where(review.product.id.ne(productId))
                .fetch();

        return queryFactory.selectFrom(review)
                .join(review.product, product).fetchJoin()
                .where(review.id.in(reviewIds))
                .fetch();
    }

    @Override
    public List<Review> findAllByMemberId(Long memberId) {
        List<Long> reviewIds = queryFactory.select(review.id)
                .from(review)
                .join(review.product, product)
                .join(review.member, member)
                .where(member.id.eq(memberId))
                .fetch();

        return queryFactory.selectFrom(review)
                .join(review.product, product).fetchJoin()
                .where(review.id.in(reviewIds))
                .fetch();
    }

    @Override
    public Optional<Review> findByIdAndMemberId(Long reviewId, Long memberId) {
        Review findReview = queryFactory.selectFrom(review)
                .join(review.member, member)
                .join(review.product, product).fetchJoin()
                .leftJoin(review.foodCategory, food).fetchJoin()
                .leftJoin(review.image, image).fetchJoin()
                .leftJoin(review.reviewHashtags, reviewHashtag).fetchJoin()
                .leftJoin(reviewHashtag.hashtag, hashtag).fetchJoin()
                .where(review.id.eq(reviewId))
                .where(member.id.eq(memberId))
                .fetchOne();

        return Optional.ofNullable(findReview);
    }
}
