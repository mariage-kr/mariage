package com.multi.mariage.like.domain.query;

import com.multi.mariage.like.domain.Like;
import com.multi.mariage.like.domain.QLike;
import com.multi.mariage.review.domain.Review;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

import static com.multi.mariage.member.domain.QMember.member;
import static com.multi.mariage.review.domain.QReview.review;

public class LikeRepositoryImpl implements LikeRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public LikeRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Optional<Like> findByMemberIdAndReviewId(Long memberId, Long reviewId) {
        Like like = queryFactory.selectFrom(QLike.like)
                .join(QLike.like.member, member).fetchJoin()
                .join(QLike.like.review, review).fetchJoin()
                .where(QLike.like.member.id.eq(memberId))
                .where(QLike.like.review.id.eq(reviewId))
                .fetchOne();

        return Optional.ofNullable(like);
    }

    @Override
    public long findCountByReview(Review review) {
        return queryFactory.select(QLike.like.count())
                .from(QLike.like)
                .where(QLike.like.review.eq(review))
                .fetchFirst();
    }
}
