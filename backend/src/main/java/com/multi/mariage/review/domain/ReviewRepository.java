package com.multi.mariage.review.domain;

import com.multi.mariage.review.domain.query.ReviewRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
}
