package com.multi.mariage.review.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewModifyResponse {
    private Long reviewId;

    public ReviewModifyResponse(Long reviewId) {
        this.reviewId = reviewId;
    }
}
