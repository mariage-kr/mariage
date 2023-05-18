package com.multi.mariage.common.fixture;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum ImageFixture {
    JPEG_IMAGE("file", "test.jpeg", MediaType.IMAGE_JPEG_VALUE, "test".getBytes()),
    JPEG_IMAGE2("file2", "test1.jpeg", MediaType.IMAGE_JPEG_VALUE, "test1".getBytes()),
    JPEG_IMAGE3("file3", "test2.jpeg", MediaType.IMAGE_JPEG_VALUE, "test2".getBytes());

    private String name;
    private String originFileName;
    private String mediaType;
    private byte[] content;

    ImageFixture(String name, String originFileName, String mediaType, byte[] content) {
        this.name = name;
        this.originFileName = originFileName;
        this.mediaType = mediaType;
        this.content = content;
    }

    public MockMultipartFile toMultipartFile() {
        return new MockMultipartFile(name, originFileName, mediaType, content);
    }

    public String getOriginFileName() {
        return this.originFileName;
    }
}
