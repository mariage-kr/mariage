package com.multi.mariage.like.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LikeCountResponse {
    private Long likedCount;

    public LikeCountResponse(Long likedCount) {
        this.likedCount = likedCount;
    }
}
