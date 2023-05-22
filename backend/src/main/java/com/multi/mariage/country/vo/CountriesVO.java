package com.multi.mariage.country.vo;

import com.multi.mariage.country.domain.Country;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class CountriesVO {
    private int id;
    private String name;
    private Country value;

    @Builder
    private CountriesVO(int id, String name, Country value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public static CountriesVO from(Country country) {
        return CountriesVO.builder()
                .id(country.getId())
                .name(country.getValue())
                .value(country)
                .build();
    }
}
