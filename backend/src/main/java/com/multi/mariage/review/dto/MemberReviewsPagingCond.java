package com.multi.mariage.review.dto;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class MemberReviewsPagingCond {
    private Long memberId;
    private int pageSize;
    private int pageNumber;
    private String sort;

    @Builder
    public MemberReviewsPagingCond(Long memberId, int pageSize, int pageNumber, String sort) {
        this.memberId = memberId;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.sort = sort;
    }
}
