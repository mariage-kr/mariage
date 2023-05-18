package com.multi.mariage.hashtag.domain;

import com.multi.mariage.review_hashtag.domain.ReviewHashtag;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    private List<ReviewHashtag> reviewHashTags = new ArrayList<>();


    }
}  public Hashtag(String name) {

    this.name = name;

    reviewHashTags.remove();
    reviewHashTags.size() == 0;
