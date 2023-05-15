package com.multi.mariage.review.dto.request;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.like.domain.Like;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.weather.domain.Weather;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewSaveRequest {

    private int productScore;
    private String productContent;
    private String foodContent;
    private int foodScore;
    private LocalDateTime date;
    private FoodCategory foodCategory;
    private Hashtag hashtag;
    // private 날씨 추가
    // 이미지 추가

}

@Builder
private ReviewSaveRequest(int productScore, String productContent, String foodContent, int foodScore, LocalDateTime date, FoodCategory foodCategory, Hashtag hashtag) {

    this.productScore = productScore;
    this.productContent = productContent;
    this.foodContent = foodContent;
    this.foodScore = foodScore;
    this.date = date;
    this.foodCategory = foodCategory;
    this.hashtag = hashtag;

}