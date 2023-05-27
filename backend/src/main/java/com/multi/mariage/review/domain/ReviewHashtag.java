package com.multi.mariage.review.domain;

import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.review.domain.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name = "review_hashtag")
@Getter
@Entity
public class ReviewHashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_hashtag_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag_id")
    private Hashtag hashtag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private Review review;

    /* 연관 관계 편의 메서드 */
    public void setHashtag(Hashtag hashtag) {
        hashtag.getReviewHashTags().add(this);
        this.hashtag = hashtag;
    }

    public void setReview(Review review) {
        review.getReviewHashtags().add(this);
        this.review = review;
    }

    public ReviewHashtag eraseHashtag() {
        if (hashtag != null) {
            hashtag.getReviewHashTags().remove(hashtag);
            hashtag = null;
        }
        return this;
    }
}
