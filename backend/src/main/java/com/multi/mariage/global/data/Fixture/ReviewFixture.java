package com.multi.mariage.global.data.Fixture;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;

import java.util.List;

import static com.multi.mariage.category.domain.FoodCategory.CHICKEN;
import static com.multi.mariage.category.domain.FoodCategory.ROAST;
import static com.multi.mariage.global.data.Fixture.MemberFixture.MARI;
import static com.multi.mariage.global.data.Fixture.MemberFixture.SURI;
import static com.multi.mariage.global.data.Fixture.ProductFixture.아사히_수퍼_드라이;
import static com.multi.mariage.global.data.Fixture.ProductFixture.참이슬_Fresh;

@SuppressWarnings("all")
public enum ReviewFixture {
    마리_참이슬_Fresh_고기(
            MARI,
            참이슬_Fresh,
            4,
            "참이슬과 고기를 먹었습니다! 고기는 참이슬과 정말로 잘 어울리는 안주입니다!",
            5,
            ROAST,
            "mari_cham_meat.jpeg",
            List.of("참이슬", "삽겹살")),
    수리_아사히_치킨(
            SURI,
            아사히_수퍼_드라이,
            5,
            "치킨에는 역시 맥주입니다. 아사히 맥주의 목 넘김이 너무 좋습니다.",
            5,
            CHICKEN,
            "suri_asahi_chicken.jpg",
            List.of("야식", "치맥")),
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
