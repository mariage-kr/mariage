package com.multi.mariage.review.dto.request;

import com.multi.mariage.category.domain.FoodCategory;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewUpdateRequest {
    private Long reviewId;
    private int productRate;
    private String content;
    @Nullable
    private int foodRate;
    @Nullable
    private FoodCategory foodCategory;
    @Nullable
    private Long newImageId;
    @Nullable
    private List<String> hashtags;

    @Builder
    public ReviewUpdateRequest(Long reviewId, int productRate, String content, int foodRate,
                               FoodCategory foodCategory, Long newImageId, List<String> hashtags) {
        this.reviewId = reviewId;
        this.productRate = productRate;
        this.content = content;
        this.foodRate = foodRate;
        this.foodCategory = foodCategory;
        this.newImageId = newImageId;
        this.hashtags = hashtags;
    }
}

//"{"request":{"reviewId":72,"productRate":3,"content":"123123","foodRate":3,"foodCategory":"ROAST","newImageId":null,"hashtags":["456"]}}"