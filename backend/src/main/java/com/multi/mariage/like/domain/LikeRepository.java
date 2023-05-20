package com.multi.mariage.like.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByMemberIdAndReviewId(Long memberId, Long reviewId);

    Optional<Like> findByMemberIdAndReviewId(Long memberId, Long reviewId);
}
