package com.multi.mariage.review.domain;

import com.multi.mariage.category.domain.FoodCategory;
import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.like.domain.Like;
import com.multi.mariage.product.domain.Product;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.weather.domain.Weather;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServerTimeUtil {
    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    public static LocalDateTime getCurrentDateTimeWithDayPrecision() {
        LocalDateTime currentDateTime = getCurrentDateTime();
        return LocalDateTime.of(currentDateTime.getYear(), currentDateTime.getMonth(), currentDateTime.getDayOfMonth(), currentDateTime.getHour(), 0, 0);
    }
}

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @Column(nullable = false)
    private int productScore;
    private String productContent;
    private String foodContent;
    private int foodScore;
    private LocalDateTime date;

    @OneToMany(mappedBy = "review")
    private List<Like> likes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weather_id", nullable = false)
    private Weather weather;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag_id")
    private Hashtag hashtag;

    @Enumerated(EnumType.STRING)
    @Column(name = "food_category_id")
    private FoodCategory foodCategory;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    /* 연관관계 편의 메서드 */
    public void setWeather(Weather weather) {
        weather.getReviews().add(this);
        this.weather = weather;
    }

    public void setProduct(Product product) {
        product.getReviews().add(this);
        this.product = product;
    }

    public void setHashtag(Hashtag hashtag) {
        hashtag.getReviews().add(this);
        this.hashtag = hashtag;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
