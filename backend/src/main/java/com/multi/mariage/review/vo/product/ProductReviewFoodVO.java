package com.multi.mariage.review.vo.product;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.review.domain.Review;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewFoodVO {
    private int id; // 음식 카테고리 고유 식별자
    private String name;
    private int rate;

    @Builder
    private ProductReviewFoodVO(int id, String name, int rate) {
        this.id = id;
        this.name = name;
        this.rate = rate;
    }

    public static ProductReviewFoodVO from(Review review) {
        if (review.getFoodCategory() == null) {
            return null;
        }
        FoodCategory foodCategory = review.getFoodCategory().getCategory();

        return ProductReviewFoodVO.builder()
                .id(foodCategory.getId())
                .name(foodCategory.getName())
                .rate(review.getFoodRate())
                .build();
    }
}
