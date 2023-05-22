package com.multi.mariage.review.vo.product;

import com.multi.mariage.weather.domain.Weather;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewContentVO {
    private String date;
    private int rate;
    private String content;
    private String img;
    private String weather;

    @Builder
    public ProductReviewContentVO(String date, int rate, String content, String img, String weather) {
        this.date = date;
        this.rate = rate;
        this.content = content;
        this.img = img;
        this.weather = weather;
    }
}
