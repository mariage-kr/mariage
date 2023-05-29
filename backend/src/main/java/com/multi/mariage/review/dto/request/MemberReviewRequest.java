package com.multi.mariage.review.dto.request;

import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MemberReviewRequest {

    private int pageSize;
    private int pageNumber;
    @Nullable
    private String sort;

    @Builder
    public MemberReviewRequest(String sort, int pageSize, int pageNumber) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.sort = sort;
    }
}
