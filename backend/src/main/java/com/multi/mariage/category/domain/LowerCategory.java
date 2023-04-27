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
    private UpperCategory upperCategory;
}
