package com.multi.mariage.hashtag.domain;

import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.common.fixture.ReviewFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class HashtagRepositoryTest extends RepositoryTest {

    @DisplayName("해시태그를 저장한다.")
    @Test
    void 해시태그를_저장한다() {
        List<String> hashtags = ReviewFixture.참이슬_과자.getHashtags();

        List<Hashtag> savedHashtags = hashtags.stream()
                .map(this::saveHashtag)
                .toList();

        assertThat(savedHashtags).hasSize(hashtags.size());
        for (int i = 0; i < hashtags.size(); i++) {
            String actual = savedHashtags.get(i).getName();
            String expected = hashtags.get(i);

            assertThat(actual).isEqualTo(expected);
        }
    }
}