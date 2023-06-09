package com.multi.mariage.storage.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.storage.domain.Image;
import com.multi.mariage.storage.dto.response.ImageSavedResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

class StorageServiceTest extends ServiceTest {
    @Value("${storagePath}")
    private String STORAGE_PATH;

    @DisplayName("파일을 저장한다.")
    @Test
    void 파일을_저장한다() {
        ImageSavedResponse actual = saveImage(ImageFixture.JPEG_IMAGE);

        assertThat(actual).isNotNull();
    }

    @DisplayName("파일을 삭제한다.")
    @Test
    void 파일을_삭제한다() {
        Long imageId = saveImage(ImageFixture.JPEG_IMAGE).getImageId();
        Image image = storageRepository.findById(imageId)
                .orElseThrow(RuntimeException::new);

        assertAll(
                () -> assertThatCode(() -> storageRepository.delete(image))
                        .doesNotThrowAnyException(),
                () -> assertThat(storageRepository.findById(imageId)).isEmpty()
        );
    }

    @DisplayName("파일의 정보를 Id로 조회한다")
    @Test
    void 파일의_정보를_Id로_조회한다() {
        /* Given */
        Long imageId = saveImage(ImageFixture.JPEG_IMAGE).getImageId();

        /* When */
        Image actual = storageService.findById(imageId);

        /* Then */
        assertThat(actual).isNotNull();
    }

    @DisplayName("파일의 저장경로를 가져온다.")
    @ParameterizedTest
    @ValueSource(strings = {"mari.png", "suri.png"})
    void 파일의_저장경로를_가져온다(String fileName) {
        String actual = storageService.getFilePath(fileName);
        String expected = STORAGE_PATH + fileName;

        assertThat(actual).isEqualTo(expected);
    }
}
