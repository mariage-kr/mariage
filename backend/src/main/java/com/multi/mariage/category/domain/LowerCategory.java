package com.multi.mariage.category.domain;

import com.multi.mariage.review.domain.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "lower_category")
@Entity
public class LowerCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lower_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private LowerValue category;

    @OneToMany(mappedBy = "lowerCategory")
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "upper_category_id")
    private UpperCategory upperCategory;

    /* 연관 관계 편의 메서드 */
    public void setUpperCategory(UpperCategory upperCategory) {
        upperCategory.getLowerCategories().add(this);
        this.upperCategory = upperCategory;
    }
}
