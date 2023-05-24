package com.multi.mariage.review.dto.response;

import com.multi.mariage.review.vo.ProductReviewVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductReviewsResponse {
    private List<ProductReviewVO> contents;
    private int pageNumber;
    private Long totalCount;
    private int pageSize;
    private int totalPages;
    private boolean isFirstPage;
    private boolean isLastPage;

    @Builder
    public ProductReviewsResponse(List<ProductReviewVO> contents, int pageNumber, Long totalCount, int pageSize,
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
