package com.multi.mariage.hashtag.service;

import com.multi.mariage.hashtag.domain.Hashtag;
import com.multi.mariage.hashtag.domain.HashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 import java.util.List;
 import java.util.Optional;
 import java.util.Iterator;
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

    public List<Hashtag> findHashTagsByList(List<String>) {
        return list.stream()
                .map(this::findByName)
                .toList();
    }


    //해시태그에 연결된 리뷰의 수가 0일때 해당 해시태그를 데이터베이스 목록에서 지우는 로직
    @Transactional
    public List<Hashtag> removeHashtagFromList(List<Hashtag> hashtags) {
        List<Hashtag> removeHashtag = new LinkedList<>();

        Iterator<Hashtag> iterator = hashtags.iterator();
        while (iterator.hasNext()) {
            Hashtag hashtag = iterator.next();
            if (hashtag.getReviewHashtags().isEmpty()) {
                iterator.remove();
                removeHashtag.add(hashtag);
            }
        }
        hashtagRepository.deleteAll(removeHashtag);

        return  hashtags;
    }
 }
