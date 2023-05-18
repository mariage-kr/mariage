package com.multi.mariage.review.dto.resonse;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewSaveResponse {
    private Long reviewId;

    public ReviewSaveResponse(Long reviewId) {
        this.reviewId = reviewId;
    }
}