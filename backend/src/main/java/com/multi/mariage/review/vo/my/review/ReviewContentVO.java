package com.multi.mariage.review.vo.my.review;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewContentVO {
    private String date;
    private int rate;
    private String content;
    private String img;

    @Builder
    public ReviewContentVO(String date, int rate, String content, String img) {
        this.date = date;
        this.rate = rate;
        this.content = content;
        this.img = img;
    }
}
