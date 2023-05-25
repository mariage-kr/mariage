package com.multi.mariage.product.domain;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.category.domain.Food;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.product.domain.embedded.Info;
import com.multi.mariage.product.domain.embedded.Level;
import com.multi.mariage.product.domain.embedded.Name;
import com.multi.mariage.product.dto.request.ProductUpdateRequest;
import com.multi.mariage.product.exception.ProductErrorCode;
import com.multi.mariage.product.exception.ProductException;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.storage.domain.Image;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Embedded
    private Name name;

    @Embedded
    private Level level;

    @Embedded
    private Info info;
    private Long totalReviewRate = 0L;
    private double avgReviewRate = 0.0D;
    @OneToMany(mappedBy = "product")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<Food> foods = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "upper_category_id", nullable = false)
    private DrinkUpperCategory upperCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "lower_category_id")
    private DrinkLowerCategory lowerCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "country_id", nullable = false)
    private Country country;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "image_id", nullable = false)
    private Image image;

    @Builder
    public Product(Name name, Level level, Info info, DrinkUpperCategory upperCategory,
                   DrinkLowerCategory lowerCategory, Country country, Image image) {
        this.name = name;
        this.level = level;
        this.info = info;
        this.upperCategory = upperCategory;
        this.lowerCategory = lowerCategory;
        this.country = country;
        this.image = image;
    }

    /* 연관관계 편의 메서드 */
    public void setImage(Image image) {
        this.image = image;
    }

    /* 비즈니스 로직 */
    public double getReviewAvgRate() {
        return (double) totalReviewRate / reviews.size();
    }

    public void changeTotalReviewRate(int score) {
        if (score <= 0) {
            throw new ProductException(ProductErrorCode.REVIEW_SCORE_CANNOT_BE_OUT_OF_RANGE);
        }
        totalReviewRate += score;
        avgReviewRate = Math.round(((double) totalReviewRate / reviews.size()) * 10) / 10.0;
    }

    public void update(ProductUpdateRequest request) {
        this.name = Name.of(request.getName());
        this.info = Info.of(request.getInfo());
        this.country = request.getCountry();
        this.upperCategory = request.getUpperCategory();
        this.lowerCategory = request.getLowerCategory();
    }

    public String getName() {
        return name.getValue();
    }

    public String getInfo() {
        return info.getValue();
    }

    public double getLevel() {
        return this.level.getValue();
    }
}
