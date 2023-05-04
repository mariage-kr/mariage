package com.multi.mariage.product.domain;

import com.multi.mariage.category.domain.LowerCategory;
import com.multi.mariage.category.domain.UpperCategory;
import com.multi.mariage.country.domain.Country;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upper_category_id", nullable = false)
    private UpperCategory upperCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lower_category_id")
    private LowerCategory lowerCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id", nullable = false)
    private Image image;

    /* 연관관계 편의 메서드 */
    public void setUpperCategory(UpperCategory upperCategory) {
        upperCategory.getProducts().add(this);
        this.upperCategory = upperCategory;
    }

    public void setLowerCategory(LowerCategory lowerCategory) {
        lowerCategory.getProducts().add(this);
        this.lowerCategory = lowerCategory;
    }

    public void setCountry(Country country) {
        this.country = country;
        country.getProducts().add(this);
    }

    public void setImage(Image image) {
        this.image = image;
    }
    @Builder
    public Product(String name, double level, String info, UpperCategory upperCategory,
                   LowerCategory lowerCategory, Country country, Image image) {
        this.name = name;
        this.level = level;
        this.info = info;
        this.upperCategory = upperCategory;
        this.lowerCategory = lowerCategory;
        this.country = country;
        this.image = image;
    }
}
