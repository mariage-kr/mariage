package com.multi.mariage.global.utils;

public abstract class PagingUtil {
    private static final int FIRST_PAGE_NUMBER = 1;

    protected int getTotalPages(int pageSize, double totalCount) {
        return (int) Math.ceil(totalCount / pageSize);
    }

    protected boolean isFirstPage(int pageNumber) {
        return pageNumber == FIRST_PAGE_NUMBER;
    }

    protected boolean isLastPage(int pageNumber, int totalPages) {
        return pageNumber >= totalPages;
    }
}
