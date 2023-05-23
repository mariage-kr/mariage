package com.multi.mariage.global.utils;

public abstract class PagingUtil {
    protected int getTotalPages(int pageSize, double totalCount) {
        return (int) Math.ceil(totalCount / pageSize);
    }

    protected boolean isFirstPage(int pageNumber) {
        return pageNumber == 1;
    }

    protected boolean isLastPage(int pageNumber, int totalPages) {
        return pageNumber >= totalPages;
    }
}
