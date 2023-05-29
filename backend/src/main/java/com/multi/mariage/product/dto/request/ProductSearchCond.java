package com.multi.mariage.product.dto.request;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class ProductSearchCond {
    private int pageSize;
    private int pageNumber;
    private String search;
    @Nullable
    private String sort;
    @Nullable
    private DrinkUpperCategory upperCategory;
    @Nullable
    private DrinkLowerCategory lowerCategory;
    private int minRate;
    private int maxRate;
    private int minLevel;
    private int maxLevel;

    @Builder
    public ProductSearchCond(int pageSize, int pageNumber, String search, String sort, DrinkUpperCategory upperCategory, DrinkLowerCategory lowerCategory, int minRate, int maxRate, int minLevel, int maxLevel) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.search = search;
        this.sort = sort;
        this.upperCategory = upperCategory;
        this.lowerCategory = lowerCategory;
        this.minRate = minRate;
        this.maxRate = maxRate;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
    }
}
