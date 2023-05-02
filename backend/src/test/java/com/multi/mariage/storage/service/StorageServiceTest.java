package com.multi.mariage.storage.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.common.fixture.ImageFixture;
import com.multi.mariage.storage.dto.response.ImageSavedResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;

import static org.assertj.core.api.Assertions.assertThat;

class StorageServiceTest extends ServiceTest {
    @Autowired
    private StorageService storageService;

    @DisplayName("파일을 저장한다.")
    @Test
    void 파일을_저장한다() {
        MockMultipartFile file = ImageFixture.JPEG_IMAGE.toMultipartFile();

        ImageSavedResponse imageId = storageService.save(file);

        assertThat(imageId).isNotNull();
    }
}