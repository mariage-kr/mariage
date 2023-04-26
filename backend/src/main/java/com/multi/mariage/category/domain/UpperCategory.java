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
@Entity
public class UpperCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "upper_id")
    private Long id;

    @OneToMany(mappedBy = "upperCategory")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "upperCategory")
    private List<LowerCategory> lowerCategories = new ArrayList<>();
}
