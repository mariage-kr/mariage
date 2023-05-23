package com.multi.mariage.product.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class RecommendCond {
    private int size;
    private String option;

    @Builder
    public RecommendCond(int size, String option) {
        this.size = size;
        this.option = option;
    }
}
