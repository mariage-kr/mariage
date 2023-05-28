package com.multi.mariage.like.domain.query;

import com.multi.mariage.like.domain.Like;
import com.multi.mariage.review.domain.Review;

import java.util.Optional;

public interface LikeRepositoryCustom {
    Optional<Like> findByMemberIdAndReviewId(Long memberId, Long reviewId);

    long findCountByReview(Review review);
}
