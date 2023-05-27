package com.multi.mariage.review.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import com.multi.mariage.hashtag.domain.Hashtag;

public interface ReviewHashtagRepository extends JpaRepository<ReviewHashtag, Long> {

    ReviewHashtag findByReviewHashtag(Review review, Hashtag hashtag);

}
