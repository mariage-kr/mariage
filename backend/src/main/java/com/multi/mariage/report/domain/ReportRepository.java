package com.multi.mariage.report.domain;

import com.multi.mariage.member.domain.Member;
import com.multi.mariage.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
    boolean existsByMemberAndReview(Member member, Review review);
}
