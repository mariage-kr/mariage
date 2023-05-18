package com.multi.mariage.hashtag.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ReviewFixture;
import com.multi.mariage.hashtag.domain.Hashtag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HashtagServiceTest extends ServiceTest {

    @DisplayName("해시태그를 저장한다")
    @Test
    void 해시태그를_저장한다() {
        List<String> hashtags = ReviewFixture.참이슬_과자.getHashtags();
        List<Hashtag> savedHashtags = hashtagService.findHashTagsByList(hashtags);

        assertThat(savedHashtags).hasSize(hashtags.size());

        for (int i = 0; i < hashtags.size(); i++) {
            String actual = savedHashtags.get(i).getName();
            assertThat(hashtags).contains(actual);
        }
    }

    @DisplayName("해시태그가 존재하지 않으면 저정하지 않는다.")
    @Test
    void 해시태그가_존재하지_않으면_저장하지_않는다() {
        List<Hashtag> savedHashtags = hashtagService.findHashTagsByList(List.of());

        assertThat(savedHashtags).isEmpty();
    }
}
