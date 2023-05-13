package com.multi.mariage.product.domain;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import com.multi.mariage.country.domain.Country;
import com.multi.mariage.product.dto.request.ProductUpdateRequest;
import com.multi.mariage.review.domain.Review;
import com.multi.mariage.storage.domain.Image;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double level;

    private String info;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "upper_category_id", nullable = false)
    private DrinkUpperCategory upperCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "lower_category_id")
    private DrinkLowerCategory lowerCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "country_id", nullable = false)
    private Country country;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id", nullable = false)
    private Image image;

    @Builder
    public Product(String name, double level, String info, DrinkUpperCategory upperCategory,
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
    public void update(ProductUpdateRequest request) {
        this.name = request.getName();
        this.info = request.getInfo();
        this.country = request.getCountry();
        this.upperCategory = request.getUpperCategory();
        this.lowerCategory = request.getLowerCategory();
    }
}
