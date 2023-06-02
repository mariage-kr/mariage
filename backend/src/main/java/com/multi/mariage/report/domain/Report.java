package com.multi.mariage.report.domain;

import com.multi.mariage.member.domain.Member;
import com.multi.mariage.review.domain.Review;
import jakarta.persistence.*;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;

    /* 연관 관계 편의 메서드 */
    public void setMember(Member member) {
        member.getReports().add(this);
        this.member = member;
    }

    public void setReview(Review review) {
        review.getReports().add(this);
        this.review = review;
    }
}
