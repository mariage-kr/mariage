package com.multi.mariage.like.domain;

import com.multi.mariage.member.domain.Member;
import com.multi.mariage.review.domain.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "liked")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;

    @Builder
    public Like(Member member, Review review) {
        setMember(member);
        setReview(review);
    }

    /* 연관관계 편의 메서드 */
    private void setMember(Member member) {
        member.getLikes().add(this);
        this.member = member;
    }

    private void setReview(Review review) {
        review.getLikes().add(this);
        this.review = review;
    }

    /* 비즈니스 로직 */
    public void removeMember() {
        member.getLikes().remove(this);
    }
}
