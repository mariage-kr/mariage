package com.multi.mariage.review.domain;

import com.multi.mariage.category.domain.Food;
import com.multi.mariage.like.domain.Like;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.weather.domain.Weather;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;
    /* TODO: 2023/05/24 1 부터 5 사이가 아니면 예외 처리 */
    private int productRate;
    /* TODO: 2023/05/24 리뷰 내용 검증 예외 처리 */
    private String content;
    /* TODO: 2023/05/24 1 부터 5 사이가 아니면 예외 처리 */
    private int foodRate;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "image_id")
    private Image image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weather_id", nullable = false)
    private Weather weather;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "review", cascade = CascadeType.REMOVE)
    private Set<Like> likes = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "review")
    private Set<ReviewHashtag> reviewHashtags = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_category_id")
    private Food foodCategory;

    @Builder
    public Review(int productRate, String content, int foodRate) {
        this.productRate = productRate;
        this.content = content;
        this.foodRate = foodRate;
        this.date = LocalDate.now(ZoneId.of("Asia/Seoul"));
    }

    public static Review from(ReviewSaveRequest request) {
        return Review.builder()
                .productRate(request.getProductRate())
                .content(request.getContent())
                .foodRate(request.getFoodRate())
                .build();
    }

    /* 연관관계 편의 메서드 */
    public void setWeather(Weather weather) {
        weather.getReviews().add(this);
        this.weather = weather;
    }

    public void setProduct(Product product) {
        this.product = product;
        product.getReviews().add(this);
        product.changeTotalReviewRate(productRate);
    }

    public void setMember(Member member) {
        member.getReviews().add(this);
        this.member = member;
    }

    public void setFoodCategory(Food foodCategory) {
        if (foodCategory == null) {
            return;
        }
        this.foodCategory = foodCategory;
        foodCategory.getReviews().add(this);
        foodCategory.changeTotalFoodRate(foodRate);
    }

    /* 비즈니스 로직 */
    public void changeImage(Image image) {
        this.image = image;
    }

    public void removeLike(Like like) {
        this.likes.remove(like);
    }

    public void removeRelated() {
        member.getReviews().remove(this);
        product.getReviews().remove(this);
    }
}
