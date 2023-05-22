package com.multi.mariage.review.vo;

import com.multi.mariage.review.vo.product.ProductReviewContentVO;
import com.multi.mariage.review.vo.product.ProductReviewFoodVO;
import com.multi.mariage.review.vo.product.ProductReviewLikeVO;
import com.multi.mariage.review.vo.product.ProductReviewMemberVO;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewVO {
    private Long id;
    private ProductReviewMemberVO member;
    private ProductReviewContentVO content;
    private ProductReviewLikeVO like;
    private ProductReviewFoodVO food;

    public ProductReviewVO(Long id, ProductReviewMemberVO member, ProductReviewContentVO content, ProductReviewLikeVO like, ProductReviewFoodVO food) {
        this.id = id;
        this.member = member;
        this.content = content;
        this.like = like;
        this.food = food;
    }
}
