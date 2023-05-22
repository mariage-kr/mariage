package com.multi.mariage.like.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByMemberIdAndReviewId(Long memberId, Long reviewId);

    Optional<Like> findByMemberIdAndReviewId(Long memberId, Long reviewId);

    @Query("SELECT COUNT(l) FROM Like l WHERE l.review.id = :reviewId")
    int countByReviewId(@Param("reviewId") Long reviewId);
}
