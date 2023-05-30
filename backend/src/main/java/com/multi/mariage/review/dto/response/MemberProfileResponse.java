package com.multi.mariage.review.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MemberProfileResponse {
    private String email;       // 사용자의 이메일
    private String imagePath;   // 사용자의 프로필 이미지
    private String nickname;    // 사용자의 닉네임
    private Long reviews;       // 사용자가 작성한 리뷰 개수
    private Long likes;         // 사용자가 좋아요한 리뷰 개수

    public MemberProfileResponse(String email, String imagePath, String nickname, Long reviews, Long likes) {
        this.email = email;
        this.imagePath = imagePath;
        this.nickname = nickname;
        this.reviews = reviews;
        this.likes = likes;
    }

    public static MemberProfileResponse from(String email, String filePath, String nickname, Long reviews, Long likes) {
        return new MemberProfileResponse(email, filePath, nickname, reviews, likes);
    }
}
