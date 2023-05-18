package com.multi.mariage.review.dto.response;

import com.multi.mariage.review.vo.ReviewVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class ReviewLikeResponse {

    private List<ReviewVO> review;
    private int length;

    @Builder
    private ReviewLikeResponse(List<ReviewVO> review, int length) {
        this.review = review;
        this.length = length;
    }

    public static ReviewLikeResponse from(List<ReviewVO> review) {
        return ReviewLikeResponse.builder()
                .review(review)
                .length(review.size())
                .build();
    }
}