package com.multi.mariage.storage.repository;

import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.storage.domain.Image;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class StorageRepositoryTest extends RepositoryTest {

    @Autowired
    protected StorageRepository storageRepository;

    @DisplayName("파일을 이름을 저장한다.")
    @Test
    void 파일의_이름을_저장한다() {
        Image image = Image.of("test.jpeg");

        Image actual = storageRepository.save(image);

        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual).isEqualTo(image)
        );
    }
}