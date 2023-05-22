package com.multi.mariage.review.vo.product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewMemberVO {
    private Long id;
    private String nickname;
    private String img;

    public ProductReviewMemberVO(Long id, String nickname, String img) {
        this.id = id;
        this.nickname = nickname;
        this.img = img;
    }
}
