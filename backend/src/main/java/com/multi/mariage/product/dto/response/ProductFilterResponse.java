package com.multi.mariage.product.dto.response;

import com.multi.mariage.product.vo.filter.ProductFilterVO;
import com.multi.mariage.review.dto.response.PageResponse;
import lombok.Builder;

import java.util.List;

public class ProductFilterResponse extends PageResponse<ProductFilterVO> {
    @Builder
    public ProductFilterResponse(List<ProductFilterVO> contents, int pageNumber, Long totalCount, int pageSize,
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
