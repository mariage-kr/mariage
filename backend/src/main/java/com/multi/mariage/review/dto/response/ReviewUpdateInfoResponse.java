package com.multi.mariage.review.dto.response;

import com.multi.mariage.category.domain.FoodCategory;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewUpdateInfoResponse {
    private String productName;
    private double productLevel;
    private String countryName;
    private int countryId;
    private int reviewProductRate;
    private String reviewContent;
    @Nullable
    private Integer foodCategoryId;
    @Nullable
    private String foodCategoryName;
    @Nullable
    private FoodCategory foodCategoryValue;
    @Nullable
    private Integer foodCategoryRate;
    @Nullable
    private String imageUrl;
    @Nullable
    private List<String> hashtags;

    @Builder
    public ReviewUpdateInfoResponse(String productName, double productLevel, String countryName, int countryId,
                                    int reviewProductRate, String reviewContent, Integer foodCategoryId,
                                    String foodCategoryName, FoodCategory foodCategoryValue, Integer foodCategoryRate,
                                    String imageUrl,
                                    List<String> hashtags) {
        this.productName = productName;
        this.productLevel = productLevel;
        this.countryName = countryName;
        this.countryId = countryId;
        this.reviewProductRate = reviewProductRate;
        this.reviewContent = reviewContent;
        this.foodCategoryId = foodCategoryId;
        this.foodCategoryName = foodCategoryName;
        this.foodCategoryValue = foodCategoryValue;
        this.foodCategoryRate = foodCategoryRate;
        this.imageUrl = imageUrl;
        this.hashtags = hashtags;
    }
}
