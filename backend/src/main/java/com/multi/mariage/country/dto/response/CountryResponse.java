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
    private List<CountriesVO> country;
    private int length;

    @Builder
    private CountryResponse(List<CountriesVO> country, int length) {
        this.country = country;
        this.length = length;
    }

    public static CountryResponse from(List<CountriesVO> country) {
        return CountryResponse.builder()
                .country(country)
                .length(country.size())
                .build();
    }

}
