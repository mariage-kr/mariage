package com.multi.mariage.review.dto.response;

import com.multi.mariage.review.vo.member.write.MemberReviewVO;
import lombok.Builder;

import java.util.List;

public class MyReviewInfoResponse extends BasePageResponse<MemberReviewVO> {
    @Builder
    public MyReviewInfoResponse(List<MemberReviewVO> contents, int pageNumber, Long totalCount, int pageSize,
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
