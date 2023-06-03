package com.multi.mariage.review.dto.request;

import com.multi.mariage.category.domain.FoodCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewUpdateRequest {
    private Long reviewId;
    private Long productId;
    private int productRate;
    private String content;
    private int foodRate;
    private FoodCategory foodCategory;
    private Long newImageId;
    private List<String> hashtags;

    @Builder
    public ReviewUpdateRequest(Long reviewId, Long productId, int productRate, String content, int foodRate, FoodCategory foodCategory, Long newImageId, List<String> hashtags) {
        this.reviewId = reviewId;
        this.productId = productId;
        this.productRate = productRate;
        this.content = content;
        this.foodRate = foodRate;
        this.foodCategory = foodCategory;
        this.newImageId = newImageId;
        this.hashtags = hashtags;
    }
}
