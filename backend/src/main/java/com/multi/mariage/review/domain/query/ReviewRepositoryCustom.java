package com.multi.mariage.review.domain.query;

import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.dto.MyReviewsPagingCond;
import com.multi.mariage.review.dto.ReviewsPagingCond;

import java.util.List;

public interface ReviewRepositoryCustom {

    List<Review> findReviewsByProductId(ReviewsPagingCond cond);

    Long findReviewsCountByProductId(Long productId);

    List<Review> findReviewsByMemberId(MyReviewsPagingCond cond);

    Long findReviewsCountByMemberId(Long memberId);
}
