package com.multi.mariage.global.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public abstract class PageResponse<T> {
    protected List<T> contents;
    protected int pageNumber;
    protected Long totalCount;
    protected int pageSize;
    protected int totalPages;
    @JsonProperty("firstPage")
    protected boolean isFirstPage;
    @JsonProperty("lastPage")
    protected boolean isLastPage;
}
