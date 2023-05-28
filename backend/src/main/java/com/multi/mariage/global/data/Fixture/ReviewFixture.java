package com.multi.mariage.global.data.Fixture;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;

import java.util.List;

import static com.multi.mariage.category.domain.FoodCategory.ROAST;
import static com.multi.mariage.global.data.Fixture.MemberFixture.MARI;
import static com.multi.mariage.global.data.Fixture.ProductFixture.참이슬_Fresh;

@SuppressWarnings("all")
public enum ReviewFixture {
    마리_참이슬_Fresh_고기(MARI, 참이슬_Fresh, 4, "참이슬과 고기", 5, ROAST, "chamisulAndMeat.jpeg", List.of("참이슬", "삽겹살")),
    ;
    private final MemberFixture member;
    private final ProductFixture product;
    private final int productRate;
    private final String content;
    private final int foodRate;
    private final FoodCategory foodCategory;
    private final String foodImagePath;
    private final List<String> hashtags;

    ReviewFixture(MemberFixture member, ProductFixture product, int productRate, String content, int foodRate, FoodCategory foodCategory, String foodImagePath, List<String> hashtags) {
        this.member = member;
        this.product = product;
        this.productRate = productRate;
        this.content = content;
        this.foodRate = foodRate;
        this.foodCategory = foodCategory;
        this.foodImagePath = foodImagePath;
        this.hashtags = hashtags;
    }

    public ReviewSaveRequest from(Long productId, Long imageId) {
        return ReviewSaveRequest.builder()
                .productId(productId)
                .productRate(productRate)
                .content(content)
                .foodRate(foodRate)
                .foodCategory(foodCategory)
                .foodImageId(imageId)
                .hashtags(hashtags)
                .build();
    }

    public String getFoodImagePath() {
        return "review/" + foodImagePath;
    }

    public String getMemberEmail() {
        return member.getEmail();
    }

    public String getProductName() {
        return product.getName();
    }
}
