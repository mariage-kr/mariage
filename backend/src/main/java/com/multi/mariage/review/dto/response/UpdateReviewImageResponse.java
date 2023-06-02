package com.multi.mariage.review.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class UpdateReviewImageResponse {
    private String imagePath;

    public UpdateReviewImageResponse(String imagePath) {
        this.imagePath = imagePath;
    }
}
