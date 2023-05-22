package com.multi.mariage.review.domain.query;

import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.dto.ReviewsPagingCond;

import java.util.List;

public interface ReviewRepositoryCustom {

    public List<Review> findReviewByProductId(ReviewsPagingCond cond);
}
