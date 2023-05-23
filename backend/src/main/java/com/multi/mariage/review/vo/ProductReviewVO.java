package com.multi.mariage.review.vo;

import com.multi.mariage.review.vo.product.ProductReviewContentVO;
import com.multi.mariage.review.vo.product.ProductReviewFoodVO;
import com.multi.mariage.review.vo.product.ProductReviewLikeVO;
import com.multi.mariage.review.vo.product.ProductReviewMemberVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewVO {
    private Long id;
    private ProductReviewMemberVO member;
    private ProductReviewContentVO content;
    private ProductReviewLikeVO like;
    private ProductReviewFoodVO food;
    private List<String> hashtags;

    @Builder
    public ProductReviewVO(Long id, ProductReviewMemberVO member, ProductReviewContentVO content,
                           ProductReviewLikeVO like, ProductReviewFoodVO food, List<String> hashtags) {
        this.id = id;
        this.member = member;
        this.content = content;
        this.like = like;
        this.food = food;
        this.hashtags = hashtags;
    }
}
