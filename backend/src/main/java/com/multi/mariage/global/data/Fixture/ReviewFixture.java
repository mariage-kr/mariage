package com.multi.mariage.global.data.Fixture;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;

import java.util.List;

import static com.multi.mariage.category.domain.FoodCategory.*;

public enum ReviewFixture {
    참이슬과_고기(4, "참이슬과 고기를 먹었습니다! 고기는 참이슬과 정말로 잘 어울리는 안주입니다!", 5, ROAST, "review/chamisulAndMeat.jpeg", List.of("참이슬", "삼겹살")),
    처음처럼과_고기(3, "처음처럼과 고기를 먹었습니다! 고기는 처음처럼과 정말로 잘 어울리는 안주입니다! 하지만 소주라 그런지 많이 먹기는 힘들었습니다.", 4, ROAST, "review/chumchurumAndMeat.jpeg", List.of("처음처럼", "삼겹살")),
    처음처럼과_피자(1, "처음처럼과 피자를 먹었습니다! 피자는 어떤 술이랑 같이 먹어야 할까요? 답은 콜라랑 먹는 게 제일 맛있습니다. 소주따위랑 같이 먹지 말고 피자만 먹으면서 맛을 음미해봅시다.", 5, PIZZA, "review/chumchurumAndPizza.jpeg", List.of("처음처럼", "피자")),
    처음처럼과_피자2(3, "처음처럼과 피자를 먹었습니다! 피자는 맛있었고 처음처럼은 적당합니다.", 4, PIZZA, "review/chumchurumAndPizza.jpeg", List.of("처음처럼", "피자")),
    처음처럼과_피자3(4, "처음처럼과 피자를 먹었습니다! 피자랑 처음처럼은 그냥저냥입니다. 다른 안주가 더 나아요.", 3, PIZZA, "review/chumchurumAndPizza.jpeg", List.of("처음처럼", "피자")),
    처음처럼과_치킨(5, "처음처럼과 치킨을 먹었습니다! 치킨에는 맥주라고 하지만 저는 동의하지 않습니다. 치킨은 처음처럼과 같이 먹어야 해요. 아닌 거 같다고요? 그럼 당신의 의견이 맞습니다!", 5, CHICKEN, "review/chumchurumAndChicken.jpeg", List.of("처음처럼", "치킨")),
    처음처럼과_치킨2(3, "처음처럼과 치킨을 먹었습니다! 치킨에 소주.. 나쁘지는 않지만 엄청 좋지도 않았습니다.", 1, CHICKEN, "review/chumchurumAndChicken.jpeg", List.of("처음처럼", "치킨")),
    처음처럼과_회(1, "처음처럼과 회를 먹었습니다! 회에는 역시 소주죠. 하지만 전 사실 소주를 싫어합니다. 소주는 맛이 없지만 회는 맛있었습니다. 안주 최고.", 3, JAPANESE, "review/chumchurumAndSashimi.jpeg", List.of("처음처럼", "회"))
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
