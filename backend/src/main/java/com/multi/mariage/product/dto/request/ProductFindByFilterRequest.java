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
public class ProductFindByFilterRequest {
    private int pageSize;
    private int pageNumber;
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
    @Nullable
    private String search;

    @Builder
    public ProductFindByFilterRequest(DrinkUpperCategory upperCategory, DrinkLowerCategory lowerCategory, int minRate
            , int maxRate, int minLevel, int maxLevel, String sort, int pageSize, int pageNumber, String search) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.upperCategory = upperCategory;
        this.lowerCategory = lowerCategory;
        this.minRate = minRate;
        this.maxRate = maxRate;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.sort = sort;
        this.search = search;
    }
}
