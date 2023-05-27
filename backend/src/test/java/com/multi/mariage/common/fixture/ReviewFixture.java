package com.multi.mariage.common.fixture;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.like.dto.request.LikeRemoveRequest;
import com.multi.mariage.like.dto.request.LikeSaveRequest;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.weather.domain.Weather;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum ReviewFixture {
    참이슬_과자(3, "참이슬과 과자를 먹었어요. 짭짜름한 과자랑 먹으니 소주를 싫어는데 잘 먹었습니다!", 5, FoodCategory.SNACK, List.of("과자", "영화")),
    참이슬_치킨(4, "참이슬과 치킨을 먹었습니다! 집에 맥주가 없어서 참이슬과 먹었는데 은근 어울리고 맛있었습니다! 치킨은 좋아요!", 5, FoodCategory.CHICKEN, List.of("야식")),
    산토리위스키_해산물(5, "산토리 위스키로 만든 하이볼을 먹었습니다! 해산물과 같이 먹었는데 조화롭게 느꼈으며 또 먹고싶은 조합입니다!", 5, FoodCategory.SEAFOOD,
            List.of("하이볼", "조개")),
    산토리위스키_해산물2(5, "산토리 위스키로 만든 하이볼을 먹었습니다! 해산물..나쁘진 않지만 전 역시 해산물은 소주랑 먹어야겠어요. 뭔가 허전하네요.", 2, FoodCategory.SEAFOOD,
            List.of("하이볼", "조개")),
    산토리위스키_과자(5, "산토리 위스키로 만든 하이볼을 먹었습니다! 과자는 맥주랑 먹어야 하는 줄 알았는데 산토리위스키와의 조합도 괜찮네요.", 3, FoodCategory.SNACK,
            List.of("하이볼", "과자")),
    산토리위스키_치즈(5, "산토리 위스키로 만든 하이볼을 먹었습니다! 치즈와 하이볼.. 먹어보고 나서 최애 궁합이 됐네요.", 4, FoodCategory.CHEESE, List.of("하이볼", "치즈")),
    산토리위스키_치즈2(4, "산토리 위스키로 만든 하이볼을 먹었습니다! 하지만 전 사실 치즈를 싫어해요. 근데 왜 같이 먹었냐고요? 살다보면 싫어도 해야 하는 순간이 있습니다.", 1,
            FoodCategory.CHEESE, List.of("치즈")),
    산토리위스키_치즈3(2, "산토리 위스키로 만든 하이볼을 먹었습니다! 치즈랑 같이 먹어도 나쁘지 않네요. ", 3, FoodCategory.CHEESE, List.of("하이볼"));

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

    public Review toReview(Member member, Product product, Image image, Weather weather) {
        Review review = Review.builder()
                .productRate(productRate)
                .content(content)
                .foodRate(foodRate)
                .build();
        review.setMember(member);
        review.setProduct(product);
        review.setWeather(weather);
        review.changeImage(image);
        return review;
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

    public List<String> getHashtags() {
        return hashtags;
    }

    public LikeSaveRequest toSaveLike(Long reviewId) {
        return new LikeSaveRequest(reviewId);
    }

    public LikeRemoveRequest toRemoveLike(Long reviewId) {
        return new LikeRemoveRequest(reviewId);
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public ReviewFixture addHashtag(Hashtag hashtag) {
        this.hashtags.add(hashtag.getName());
        return this;
    }
}
