package com.multi.mariage.review.dto.request;

import com.multi.mariage.category.domain.FoodCategory;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewModifyRequest {
    private Long id;
    private Long productId;
    private int productRate;
    private String content;
    private int foodRate;
    private FoodCategory foodCategory;
    private Long foodImageId;
    private Long newFoodImageId;
    private List<String> hashtags;

    public ReviewModifyRequest(Long id, Long productId, int productRate, String content, int foodRate, FoodCategory foodCategory, Long foodImageId, Long newFoodImageId, List<String> hashtags) {
        this.id = id;
        this.productId = productId;
        this.productRate = productRate;
        this.content = content;
        this.foodRate = foodRate;
        this.foodCategory = foodCategory;
        this.foodImageId = foodImageId;
        this.newFoodImageId = newFoodImageId;
        this.hashtags = hashtags;
    }
}
