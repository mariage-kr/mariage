package com.multi.mariage.global.data.Fixture;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;

import java.util.List;

import static com.multi.mariage.category.domain.FoodCategory.ROAST;

public enum ReviewFixture {
    참이슬과_고기(4, "참이슬과 고기를 먹었습니다! 고기는 참이슬과 정말로 잘 어울리는 안주입니다!", 5, ROAST, "review/chamisulAndMeat.jpeg", List.of("참이슬", "삼겹살")),
    참이슬과_고기2(4, "참이슬과 목살을 먹었습니다! 목살은 참이슬과 정말로 잘 어울리는 안주입니다! 하지만 개인적으로는 삼겹살이 더 좋은것 같아요!", 4, ROAST, "review/chamisulAndMeat2.jpeg", List.of("참이슬", "삼겹살")),
    처음처럼과_고기(3, "처음처럼과 고기를 먹었습니다! 고기는 처음처럼과 정말로 잘 어울리는 안주입니다! 하지만 소주라 그런지 많이 먹기는 힘들었습니다.", 5, ROAST, "review/chumchurumAndMeat.jpeg", List.of("참이슬", "삼겹살")),
    ;
    private final int productRate;
    private final String content;
    private final int foodRate;
    private final FoodCategory foodCategory;
    private final String foodImagePath;
    private final List<String> hashtags;

    ReviewFixture(int productRate, String content,
                  int foodRate, FoodCategory foodCategory, String foodImagePath, List<String> hashtags) {
        this.productRate = productRate;
        this.content = content;
        this.foodRate = foodRate;
        this.foodCategory = foodCategory;
        this.foodImagePath = foodImagePath;
        this.hashtags = hashtags;
    }

    public ReviewSaveRequest toSaveRequest(Long productId, Long foodImageId) {
        return ReviewSaveRequest.builder()
                .productId(productId)
                .productRate(productRate)
                .content(content)
                .foodRate(foodRate)
                .foodCategory(foodCategory)
                .foodImageId(foodImageId)
                .hashtags(hashtags)
                .build();
    }

    public String getFoodImagePath() {
        return foodImagePath;
    }
}
