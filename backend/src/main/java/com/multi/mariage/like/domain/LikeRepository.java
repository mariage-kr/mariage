package com.multi.mariage.like.domain;

import com.multi.mariage.like.domain.query.LikeRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikeRepository extends JpaRepository<Like, Long>, LikeRepositoryCustom {
    boolean existsByMemberIdAndReviewId(Long memberId, Long reviewId);

    @Query("SELECT COUNT(l) FROM Like l WHERE l.review.id = :reviewId")
    int countByReviewId(@Param("reviewId") Long reviewId);
}
