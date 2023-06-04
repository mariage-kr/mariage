package com.multi.mariage.review.dto.response;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.product.dto.response.ProductFindResponse;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.domain.ReviewHashtag;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewUpdateResponse {
    private Long reviewId;
    private int productRate;
    private String content;
    private int foodRate;
    private FoodCategory foodCategory;
    private String imagePath;
    private List<ReviewHashtag> hashtags;

    @Builder
    private ReviewUpdateResponse(Long reviewId, int productRate, String content, int foodRate, FoodCategory foodCategory, String imagePath, List<ReviewHashtag> hashtags) {
        this.reviewId = reviewId;
        this.productRate = productRate;
        this.content = content;
        this.foodRate = foodRate;
        this.foodCategory = foodCategory;
        this.imagePath = imagePath;
        this.hashtags = hashtags;
    }

    public static ReviewUpdateResponse from(Review review, String imagePath, List<ReviewHashtag> hashtags) {
        return ReviewUpdateResponse.builder()
                .reviewId(review.getId())
                .productRate(review.getProductRate())
                .content(review.getContent())
                .foodRate(review.getFoodRate())
                .foodCategory(review.getFoodCategory().getCategory())
                .imagePath(imagePath)
                .hashtags(hashtags)
                .build();
    }
}
