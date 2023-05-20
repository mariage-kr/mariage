package com.multi.mariage.like.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class LikeRemoveRequest {
    private Long reviewId;
    public LikeRemoveRequest(Long reviewId) {
        this.reviewId = reviewId;
    }
}
