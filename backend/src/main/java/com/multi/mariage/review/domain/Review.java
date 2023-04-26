package com.multi.mariage.review.domain;

import com.multi.mariage.category.domain.LowerCategory;
import com.multi.mariage.category.domain.UpperCategory;
import com.multi.mariage.like.domain.Like;
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
    private UpperCategory upperCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    private LowerCategory lowerCategory;
}
