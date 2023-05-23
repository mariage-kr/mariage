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

     public ReviewHashtag findById(Long reviewHashtagId) {
         Optional<ReviewHashtag> reviewHashtag = reviewHashtagRepository.findById(reviewHashtagId);
         return reviewHashtag.orElse(null);
     }

     @Transactional
     public void removeHashtagFromReview(Long reviewHashtagId) {
         Optional<ReviewHashtag> reviewHashtagOptional = reviewHashtagRepository.findById(reviewHashtagId);
         if (reviewHashtagOptional.isPresent()) {
             ReviewHashtag reviewHashtag = reviewHashtagOptional.get();
             reviewHashtag.removeHashtag();
             reviewHashtagRepository.delete(reviewHashtag);
         }
     }
}
