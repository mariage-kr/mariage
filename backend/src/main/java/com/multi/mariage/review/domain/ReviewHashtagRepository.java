package com.multi.mariage.review.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewHashtagRepository extends JpaRepository<ReviewHashtag, Long> {
//    List<ReviewHashtag> findAllByReviewId(Long reviewId);
//
//    Optional<ReviewHashtag> findByReviewId(Long reviewId);
//
//    boolean existsByHashTagId(Long hashTagId);
//
//    void deleteAllByReview(Review review);

}
