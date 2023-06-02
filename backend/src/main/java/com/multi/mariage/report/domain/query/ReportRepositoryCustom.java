package com.multi.mariage.report.domain.query;

import com.multi.mariage.review.domain.Review;

public interface ReportRepositoryCustom {
    Long findCountByReview(Review review);
}
