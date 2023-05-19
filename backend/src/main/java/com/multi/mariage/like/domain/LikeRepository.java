package com.multi.mariage.like.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByMemberIdAndReviewId(Long memberId, Long reviewId);
}
