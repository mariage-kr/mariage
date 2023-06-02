package com.multi.mariage.review.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewDeleteResponse {
    private Long reviewId;

    public ReviewDeleteResponse(Long reviewId) {
        this.reviewId = reviewId;
    }
}
