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
    private ProductReviewContentVO review;
    private ProductReviewLikeVO like;
    private ProductReviewFoodVO food;
    private List<String> hashtags;

    @Builder
    public ProductReviewVO(Long id, ProductReviewMemberVO member, ProductReviewContentVO review,
                           ProductReviewLikeVO like, ProductReviewFoodVO food, List<String> hashtags) {
        this.id = id;
        this.member = member;
        this.review = review;
        this.like = like;
        this.food = food;
        this.hashtags = hashtags;
    }
}
