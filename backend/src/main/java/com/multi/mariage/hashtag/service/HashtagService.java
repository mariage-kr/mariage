package com.multi.mariage.hashtag.service;

import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.hashtag.domain.HashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.LinkedList;

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
        return list.stream()
                .map(this::findByName)
                .toList();
        }

        // 해시태그가 0되면 해시태그 자체를 지우기
        public List<Hashtag> removeHashtagFromList(List<Hashtag> hashtags) {
            List<Hashtag> removeHashtag = new LinkedList<>();

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
