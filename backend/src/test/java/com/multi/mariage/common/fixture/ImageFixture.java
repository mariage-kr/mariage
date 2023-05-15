package com.multi.mariage.common.fixture;

import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

@Getter
public enum ImageFixture {
    JPEG_IMAGE("file", "test.jpeg", MediaType.IMAGE_JPEG_VALUE, "test".getBytes()),
    JPEG_IMAGE2("file2", "test1.jpeg", MediaType.IMAGE_JPEG_VALUE, "test1".getBytes()),
    JPEG_IMAGE3("file3", "test2.jpeg", MediaType.IMAGE_JPEG_VALUE, "test2".getBytes());

    private final String name;
    private final String originFileName;
    private final String mediaType;
    private final byte[] content;

    ImageFixture(String name, String originFileName, String mediaType, byte[] content) {
        this.name = name;
        this.originFileName = originFileName;
        this.mediaType = mediaType;
        this.content = content;
    }

    public MockMultipartFile toMultipartFile() {
        return new MockMultipartFile(name, originFileName, mediaType, content);
    }
}
