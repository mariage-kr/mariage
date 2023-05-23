package com.multi.mariage.review.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewRateVO {
    private int reviewRate;
    private int percentage;

    @Builder
    private ReviewRateVO(int reviewRate, int percentage) {
        this.reviewRate = reviewRate;
        this.percentage = percentage;
    }

    public static ReviewRateVO from(int reviewRate, int percentage) {
        return new ReviewRateVO(reviewRate, percentage);
    }
}
