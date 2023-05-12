package com.multi.mariage.like.domain;

import com.multi.mariage.member.domain.Member;
import com.multi.mariage.review.domain.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;

    /* 연관관계 편의 메서드 */
    public void setMember(Member member) {
        member.getLikes().add(this);
        this.member = member;
    }

    public void setReview(Review review) {
        review.getLikes().add(this);
        this.review = review;
    }
}
