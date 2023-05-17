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

    public List<Hashtag> findHashTagsByList(List<String> list) {
        return list.stream()
                .map(this::findByName)
                .toList();
    }
}
