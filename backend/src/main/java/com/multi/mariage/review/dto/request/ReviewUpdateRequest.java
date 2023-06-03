package com.multi.mariage.review.dto.request;

import com.multi.mariage.category.domain.FoodCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewUpdateRequest {
    private Long id;
    private Long productId;
    private int productRate;
    private String content;
    private int foodRate;
    private FoodCategory foodCategory;
    private Long foodImageId;
    private List<String> hashtags;

    @Builder
    public ReviewUpdateRequest(Long id, Long productId, int productRate, String content, int foodRate, FoodCategory foodCategory, Long foodImageId, List<String> hashtags) {
        this.id = id;
        this.productId = productId;
        this.productRate = productRate;
        this.content = content;
        this.foodRate = foodRate;
        this.foodCategory = foodCategory;
        this.foodImageId = foodImageId;
        this.hashtags = hashtags;
    }
}
