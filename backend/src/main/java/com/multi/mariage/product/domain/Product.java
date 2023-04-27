package com.multi.mariage.product.domain;

import com.multi.mariage.country.domain.Country;
import com.multi.mariage.review.domain.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews = new ArrayList<>();

    /* 연관 관계 편의 메서드 */
    public void setCountry(Country country) {
        this.country = country;
        country.getProducts().add(this);
    }
}
