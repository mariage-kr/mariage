package com.multi.mariage.review.domain.query;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.dto.cond.MemberReviewsPagingCond;
import com.multi.mariage.review.dto.cond.ReviewsPagingCond;

import java.util.List;
import java.util.Optional;

public interface ReviewRepositoryCustom {

    List<Review> findReviewsByProductId(ReviewsPagingCond cond);

    Long findReviewsCountByProductId(Long productId, FoodCategory foodCategory, Integer rate);

    List<Review> findRatedReviewsByMemberId(MemberReviewsPagingCond cond);

    Long findReviewsCountByRatings(Long memberId);

    List<Review> findLikedReviewsByMemberId(MemberReviewsPagingCond cond);

    Long findReviewsCountByLikes(Long memberId);

    Optional<Review> findByIdToDelete(Long reviewId);

    Optional<Review> findByIdToUpdate(Long reviewId);

    List<Review> findAllByMemberIdAndProductId(Long memberId, Long productId);

    List<Review> findAllByMemberId(Long memberId);
}
