package com.multi.mariage.review.dto.response;

import com.multi.mariage.category.domain.FoodCategory;
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
    public ReviewUpdateResponse(Long reviewId, int productRate, String content, int foodRate, FoodCategory foodCategory, String imagePath, List<ReviewHashtag> hashtags) {
        this.reviewId = reviewId;
        this.productRate = productRate;
        this.content = content;
        this.foodRate = foodRate;
        this.foodCategory = foodCategory;
        this.imagePath = imagePath;
        this.hashtags = hashtags;
    }
}
