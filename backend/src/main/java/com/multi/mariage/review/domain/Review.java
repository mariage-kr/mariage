package com.multi.mariage.review.domain;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.like.domain.Like;
import com.multi.mariage.member.domain.Member;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.dto.request.ReviewSaveRequest;
import com.multi.mariage.review_hashtag.domain.ReviewHashtag;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.weather.domain.Weather;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;
    private int productRate;
    private String content;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "review")
    private List<Like> likes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "review")
    private List<ReviewHashtag> reviewHashtags = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "food_category_id")
    private FoodCategory foodCategory;

    @Builder
    public Review(int productRate, String content, int foodRate, FoodCategory foodCategory) {
        this.productRate = productRate;
        this.content = content;
        this.foodRate = foodRate;
        this.foodCategory = foodCategory;
        this.date = LocalDate.now(ZoneId.of("Asia/Seoul"));
    }

    public static Review from(ReviewSaveRequest request) {
        return Review.builder()
                .productRate(request.getProductRate())
                .content(request.getContent())
                .foodRate(request.getFoodRate())
                .foodCategory(request.getFoodCategory())
                .build();
    }

    /* 연관관계 편의 메서드 */
    public void setWeather(Weather weather) {
        weather.getReviews().add(this);
        this.weather = weather;
    }

    public void setProduct(Product product) {
        product.getReviews().add(this);
        this.product = product;
    }

    public void setMember(Member member) {
        member.getReviews().add(this);
        this.member = member;
    }

    /* 비즈니스 로직 */
    public void changeImage(Image image) {
        this.image = image;
    }

    public void removeHashtags() {
        for (ReviewHashtag reviewHashtag : reviewHashtags) {
            reviewHashtag.removeHashtag
        }
    }
}
