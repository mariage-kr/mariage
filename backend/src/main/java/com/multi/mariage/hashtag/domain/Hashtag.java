package com.multi.mariage.hashtag.domain;

import com.multi.mariage.review.domain.ReviewHashtag;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hashtag_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hashtag")
    private Set<ReviewHashtag> reviewHashTags = new HashSet<>();

    public Hashtag(String name) {
        this.name = name;
    }
}
