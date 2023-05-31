package com.multi.mariage.review.dto.request;

import com.multi.mariage.category.domain.FoodCategory;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewDetailRequest {
    @Nullable
    private Long memberId;
    @Nullable
    private FoodCategory category;
    @Nullable
    private Integer rate;
    private String sort;
    private int pageNumber;
    private int pageSize;

    @Builder
    public ReviewDetailRequest(Long memberId, FoodCategory category, int rate, String sort, int pageNumber,
                               int pageSize) {
        this.memberId = memberId;
        this.category = category;
        this.rate = rate;
        this.sort = sort;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
