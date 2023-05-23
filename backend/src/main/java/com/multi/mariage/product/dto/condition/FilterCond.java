package com.multi.mariage.product.dto.condition;

import com.multi.mariage.category.domain.DrinkLowerCategory;
import com.multi.mariage.category.domain.DrinkUpperCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class FilterCond {
    private DrinkUpperCategory upperCategory;
    private DrinkLowerCategory lowerCategory;
    private int minRate;
    private int maxRate;
    private int minLevel;
    private int maxLevel;
    private String sort;

    @Builder
    public FilterCond(DrinkUpperCategory upperCategory, DrinkLowerCategory lowerCategory, int minRate, int maxRate, int minLevel, int maxLevel, String sort) {
        this.upperCategory = upperCategory;
        this.lowerCategory = lowerCategory;
        this.minRate = minRate;
        this.maxRate = maxRate;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.sort = sort;
    }
}
