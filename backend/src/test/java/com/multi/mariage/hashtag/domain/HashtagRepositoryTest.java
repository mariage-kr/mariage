package com.multi.mariage.hashtag.domain;

import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.common.fixture.HashtagFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HashtagRepositoryTest extends RepositoryTest {

    @DisplayName("해시태그를 저장한다.")
    @Test
    void 해시태그를_저장한다() {
        Hashtag actual = saveHashtag(HashtagFixture.치맥);

        assertThat(actual).isNotNull();
    }
}