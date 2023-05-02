package com.multi.mariage.storage.dto.response;

import com.multi.mariage.storage.domain.Image;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ImageSavedResponse {
    private Long imageId;

    private ImageSavedResponse(Long imageId) {
        this.imageId = imageId;
    }

    public static ImageSavedResponse from(Image image) {
        return new ImageSavedResponse(image.getId());
    }
}
