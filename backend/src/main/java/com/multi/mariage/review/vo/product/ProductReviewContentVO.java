package com.multi.mariage.review.vo.product;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewContentVO {
    private String date;
    private double rate;
    private String content;
    private String img;
}
