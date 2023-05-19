package com.multi.mariage.review_hashtag.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewHashtagRepository extends JpaRepository<ReviewHashtag, Long> {
    ReviewHashtag findById(Long reviewId, Long hashtagId);
}
