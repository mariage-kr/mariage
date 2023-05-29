package com.multi.mariage.review.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public abstract class PageResponse<T> {
    public List<T> contents;
    public int pageNumber;
    public Long totalCount;
    public int pageSize;
    public int totalPages;
    @JsonProperty("firstPage")
    public boolean isFirstPage;
    @JsonProperty("lastPage")
    public boolean isLastPage;
}
