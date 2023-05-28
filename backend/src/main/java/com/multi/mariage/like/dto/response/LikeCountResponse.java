package com.multi.mariage.like.dto.response;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LikeCountResponse {
    private int likedCount;

    public LikeCountResponse(int likedCount) {
        this.likedCount = likedCount;
    }

    public int getLikedCount() {
        return likedCount;
    }
}
