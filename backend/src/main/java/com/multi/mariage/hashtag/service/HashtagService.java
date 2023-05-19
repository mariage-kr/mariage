package com.multi.mariage.hashtag.service;

import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.hashtag.domain.HashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        List<Hashtag> hashtags = list.stream()
                .map(this::findByName)
                .toList();

        // reviewHashTags의 크기가 0인 경우 Hashtag 삭제
        hashtags.stream()
                .filter(hashtag -> hashtag.getReviewHashTags().size() == 0)
                .forEach(hashtag -> hashtagRepository.delete(hashtag));

        return hashtags;
    }
}
