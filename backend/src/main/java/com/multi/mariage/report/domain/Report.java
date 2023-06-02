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

    public static Report from(Member member, Review review) {
        Report report = new Report();
        report.setMember(member);
        report.setReview(review);
        return report;
    }

    /* 연관 관계 편의 메서드 */
    private void setMember(Member member) {
        member.getReports().add(this);
        this.member = member;
    }

    private void setReview(Review review) {
        review.getReports().add(this);
        this.review = review;
    }
}
