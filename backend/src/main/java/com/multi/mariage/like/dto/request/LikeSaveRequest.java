package com.multi.mariage.like.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class LikeSaveRequest {
    private Long reviewId;

    public LikeSaveRequest(Long reviewId) {
        this.reviewId = reviewId;
    }
}
