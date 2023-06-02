package com.multi.mariage.review.dto.response;

import com.multi.mariage.global.dto.PageResponse;
import com.multi.mariage.review.vo.member.MemberReviewVO;
import lombok.Builder;

import java.util.List;

public class MemberReviewInfoResponse extends PageResponse<MemberReviewVO> {
    @Builder
    public MemberReviewInfoResponse(List<MemberReviewVO> contents, int pageNumber, Long totalCount, int pageSize,
                                    int totalPages, boolean isFirstPage, boolean isLastPage) {
        this.contents = contents;
        this.pageNumber = pageNumber;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
    }
}
