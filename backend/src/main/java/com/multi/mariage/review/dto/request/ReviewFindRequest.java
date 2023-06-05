package com.multi.mariage.review.dto.request;

import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ReviewFindRequest {

    private int pageSize;
    private int pageNumber;
    @Nullable
    private Long visitMemberId;

    @Builder
    public ReviewFindRequest(int pageSize, int pageNumber, Long visitMemberId) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.visitMemberId = visitMemberId;
    }
}
