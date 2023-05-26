package com.multi.mariage.review.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multi.mariage.hashtag.domain.Hashtag;

import java.util.List;

public interface ReviewHashtagRepository extends JpaRepository<ReviewHashtag, Long> {

    List<ReviewHashtag> getReviewHashtag();

    default List<ReviewHashtag> reviewHashtag() {
        return getReviewHashtag();
    }

    ReviewHashtag findByReviewAndHashtag(Review review, Hashtag hashtag);
}
