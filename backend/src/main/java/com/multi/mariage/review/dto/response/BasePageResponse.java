package com.multi.mariage.review.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public abstract class BasePageResponse<T> {
    public List<T> contents;
    public int pageNumber;
    public Long totalCount;
    public int pageSize;
    public int totalPages;
    public boolean isFirstPage;
    public boolean isLastPage;
}
