package com.multi.mariage.category.domain;

import com.multi.mariage.product.domain.Product;
import com.multi.mariage.review.domain.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private FoodCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "foodCategory")
    private List<Review> reviews = new ArrayList<>();

    private Long totalFoodRate = 0L;
    private double avgFoodRate = 0D;

    public Food(FoodCategory foodCategory) {
        this.category = foodCategory;
    }

    /* 연관관계 편의 메서드 */
    public void setProduct(Product product) {
        this.product = product;
        product.getFoods().add(this);
    }

    /* 비즈니스 로직 */
    public void changeTotalFoodRate(int rate) {
        totalFoodRate += rate;
        avgFoodRate = (double) totalFoodRate / reviews.size();
    }
}
