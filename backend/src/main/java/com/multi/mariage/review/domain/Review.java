package com.multi.mariage.review.domain;

import com.multi.mariage.category.domain.LowerCategory;
import com.multi.mariage.category.domain.UpperCategory;
import com.multi.mariage.like.domain.Like;
import com.multi.mariage.weather.domain.Weather;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
    private int productScore;
    private String productContent;
    private String foodContent;
    private int foodScore;
    private LocalDateTime date;

    @OneToMany(mappedBy = "review")
    private List<Like> likes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upper_category_id")
    private UpperCategory upperCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lower_category_id")
    private LowerCategory lowerCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weather_id")
    private Weather weather;

    /* 연관 관계 편의 메서드 */
    public void setUpperCategory(UpperCategory upperCategory) {
        upperCategory.getReviews().add(this);
        this.upperCategory = upperCategory;
    }

    public void setLowerCategory(LowerCategory lowerCategory) {
        lowerCategory.getReviews().add(this);
        this.lowerCategory = lowerCategory;
    }


    public void setWeather(Weather weather) {
        weather.getReviews().add(this);
        this.weather = weather;
    }
}
