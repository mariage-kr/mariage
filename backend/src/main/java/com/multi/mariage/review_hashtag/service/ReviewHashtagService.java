package com.multi.mariage.review_hashtag.service;

 import com.multi.mariage.hashtag.domain.Hashtag;
 import com.multi.mariage.hashtag.service.HashtagService;
 import com.multi.mariage.review.domain.Review;
 import com.multi.mariage.review_hashtag.domain.ReviewHashtag;
 import com.multi.mariage.review_hashtag.domain.ReviewHashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 import java.util.List;
 import java.util.Optional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ReviewHashtagService {
    private final ReviewHashtagRepository reviewHashtagRepository;
    private final HashtagService hashtagService;

    public List<ReviewHashtag> saveAll(List<String> names, Review review) {
        List<Hashtag> hashtags = hashtagService.findHashTagsByList(names);
        return hashtags.stream()
                .map(hashtag -> save(hashtag, review))
                .toList();
    }

    private ReviewHashtag save(Hashtag hashtag, Review review) {
        ReviewHashtag reviewHashtag = new ReviewHashtag();

        reviewHashtag.setHashtag(hashtag);
        reviewHashtag.setReview(review);

        return reviewHashtagRepository.save(reviewHashtag);
    }

    public ReviewHashtag findById(Long id) {
        Optional<ReviewHashtag> optionalReviewHashtag = reviewHashtagRepository.findById(id);

        if (optionalReviewHashtag.isPresent()) {
            ReviewHashtag reviewHashtag = optionalReviewHashtag.get();
            return reviewHashtag;
        } else {
            return null;
        }
    }

    @Transactional
    public void removeHashtags(List<String> hashtagsToRemove) {
        Iterator<ReviewHashtag> iterator = reviewHashtagRepository.reviewHashtag.iterator();
        while (iterator.hasNext()) {
            ReviewHashtag reviewHashtag = iterator.next();
            if (hashtagsToRemove.contains(reviewHashtag.getHashtag().getId())) {
                reviewHashtag.removeHashtag();
                iterator.remove();
            }
        }
    }
}
