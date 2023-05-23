package com.multi.mariage.product.dto.response;

import com.multi.mariage.product.vo.filter.ProductFilterVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductFilterResponse {
    private ProductFilterVO contents;
    private int pageNumber;
    private Long totalCount;
    private int pageSize;
    private int totalPages;
    private boolean isFirstPage;
    private boolean isLastPage;

    @Builder
    public ProductFilterResponse(ProductFilterVO contents, int pageNumber, Long totalCount, int pageSize, int totalPages, boolean isFirstPage, boolean isLastPage) {
        this.contents = contents;
        this.pageNumber = pageNumber;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.isFirstPage = isFirstPage;
        this.isLastPage = isLastPage;
    }
}
