package com.multi.mariage.review.vo.member.write;

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
public class ReviewInfoVO {
    private Long id;
    private ProductReviewMemberVO member;
    private ReviewContentVO review;
    private ProductReviewLikeVO like;
    private ProductReviewFoodVO food;
    private List<String> hashtags;

    @Builder
    private ReviewInfoVO(Long id, ProductReviewMemberVO member, ReviewContentVO review,
                         ProductReviewLikeVO like, ProductReviewFoodVO food, List<String> hashtags) {
        this.id = id;
        this.member = member;
        this.review = review;
        this.like = like;
        this.food = food;
        this.hashtags = hashtags;
    }

    public static ReviewInfoVO from(Long id, ProductReviewMemberVO member, ReviewContentVO review,
                                    ProductReviewLikeVO like, ProductReviewFoodVO food, List<String> hashtags) {
        return ReviewInfoVO.builder()
                .id(id)
                .member(member)
                .review(review)
                .like(like)
                .food(food)
                .hashtags(hashtags)
                .build();
    }
}
