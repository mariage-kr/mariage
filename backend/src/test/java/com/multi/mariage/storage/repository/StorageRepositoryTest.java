package com.multi.mariage.storage.repository;

import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.storage.domain.Image;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class StorageRepositoryTest extends RepositoryTest {

    @Autowired
    protected StorageRepository storageRepository;

    @DisplayName("파일의 이름을 저장한다.")
    @Test
    void 파일의_이름을_저장한다() {
        Image image = Image.of("test.jpeg");

        Image actual = storageRepository.save(image);

        assertAll(
                () -> assertThat(actual).isNotNull(),
                () -> assertThat(actual).isEqualTo(image)
        );
    }

    @DisplayName("파일의 정보를 삭제한다.")
    @Test
    void 파일의_정보를_삭제한다() {
        /* Given */
        Image image = Image.of("test.jpeg");
        Image saveImage = storageRepository.save(image);

        /* When */
        storageRepository.delete(saveImage);
        Optional<Image> actual = storageRepository.findById(saveImage.getId());

        /* Then */
        assertThat(actual).isEmpty();
    }
}