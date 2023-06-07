package com.multi.mariage.review.dto.response;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.review.domain.Review;
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
    private Integer foodRate;
    private FoodCategory foodCategory;
    private String imagePath;
    private List<String> hashtags;

    @Builder
    private ReviewUpdateResponse(Long reviewId, int productRate, String content, Integer foodRate, FoodCategory foodCategory, String imagePath, List<String> hashtags) {
        this.reviewId = reviewId;
        this.productRate = productRate;
        this.content = content;
        this.foodRate = foodRate;
        this.foodCategory = foodCategory;
        this.imagePath = imagePath;
        this.hashtags = hashtags;
    }

    public static ReviewUpdateResponse from(Review review, String imagePath, List<String> hashtags) {
        return ReviewUpdateResponse.builder()
                .reviewId(review.getId())
                .productRate(review.getProductRate())
                .content(review.getContent())
                .foodRate(review.getFoodRate())
                .foodCategory(review.getFoodCategory() != null ? review.getFoodCategory().getCategory() : null)
                .imagePath(imagePath)
                .hashtags(hashtags)
                .build();
    }
}
