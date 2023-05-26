package com.multi.mariage.hashtag.service;

import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.hashtag.domain.HashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Iterator.*;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class HashtagService {

    private final HashtagRepository hashtagRepository;

    @Transactional
    public List<Hashtag> findHashTagsByList(List<String> list) {
        return list.stream()
                .map(this::findByName)
                .toList();
    }

    private Hashtag findByName(String name) {
        Optional<Hashtag> hashtag = hashtagRepository.findByName(name);

        if (hashtag.isEmpty()) {
            return hashtagRepository.save(new Hashtag(name));
        }

        return hashtag.get();
    }

    // 해시태그에 연결된 리뷰의 수가 0일때 해당 해시태그를 데이터베이스 목록에서 지우는 로직
    @Transactional
    public List<Hashtag> removeHashtagFromList(List<Hashtag> hashtags) {
        List<Hashtag> removeHashtag = new LinkedList<>();
        hashtags.removeIf(hashtag -> {
            if (hashtag.getReviewHashtags().isEmpty()) {
                removeHashtag.add(hashtag);
                return true;
            }
            return false;
        });

        hashtagRepository.deleteAll(removeHashtag);

        return hashtags;
    }
}
