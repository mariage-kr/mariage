package com.multi.mariage.hashtag.service;

import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.hashtag.domain.HashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class HashtagService {

    private final HashtagRepository hashtagRepository;

    private Hashtag findByName(String name) {
        Optional<Hashtag> hashtag = hashtagRepository.findByName(name);

        if (hashtag.isEmpty()) {
            return hashtagRepository.save(new Hashtag(name));
        }

        return hashtag.get();
    }

    @Transactional
    public List<Hashtag> findHashTagsByList(List<String> list) {
        List<Hashtag> hashtags = new ArrayList<>();

        for (String name : list) {
            Hashtag hashtag = findByName(name);
            hashtags.add(hashtag);
        }

        // Remove hashtags with no associated reviewHashTags
        List<Hashtag> removeHashtag = new ArrayList<>();
        for (Hashtag hashtag : hashtags) {
            if (hashtag.getReviewHashTags().size() == 0) {
                removeHashtag.add(hashtag);
            }
        }

        for (Hashtag hashtagsToRemove : removeHashtag) {
            hashtagRepository.delete(hashtagsToRemove);
        }

        return hashtags;
    }
}
