package com.multi.mariage.country.dto.response;

import com.multi.mariage.category.vo.food.FoodCategoriesVO;
import com.multi.mariage.country.vo.CountriesVO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class CountryResponse {
    private List<CountriesVO> category;
    private int length;

    @Builder
    private CountryResponse(List<CountriesVO> category, int length) {
        this.category = category;
        this.length = length;
    }

    public static CountryResponse from(List<CountriesVO> country) {
        return CountryResponse.builder()
                .category(country)
                .length(country.size())
                .build();
    }

}
