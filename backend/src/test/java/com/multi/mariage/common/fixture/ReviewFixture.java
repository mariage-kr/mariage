package com.multi.mariage.common.fixture;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.weather.domain.Weather;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum ReviewFixture {
    참이슬_과자(3, "참이슬과 과자를 먹었어요. 짭짜름한 과자랑 먹으니 소주를 싫어는데 잘 먹었습니다!", 5, FoodCategory.SNACK, List.of("과자", "영화"));
    private int productRate;
    private String content;
    private int foodRate;
    private FoodCategory foodCategory;
    private List<String> hashtags;

    ReviewFixture(int productRate, String content, int foodRate, FoodCategory foodCategory, List<String> hashtags) {
        this.productRate = productRate;
        this.content = content;
        this.foodRate = foodRate;
        this.foodCategory = foodCategory;
        this.hashtags = hashtags;
    }

    Review toReview(Member member, Product product, Image image, Weather weather) {
        Review review = Review.builder()
                .productRate(productRate)
                .content(content)
                .foodRate(foodRate)
                .foodCategory(foodCategory)
                .build();
        review.setMember(member);
        review.setProduct(product);
        review.setWeather(weather);
        review.changeImage(image);
        return review;
    }
}
