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
    private String flag;

    @Builder
    private CountriesVO(int id, String name, String flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }

    public static CountriesVO from(Country country) {
        return CountriesVO.builder()
                .id(country.getId())
                .name(country.getCountry())
                .flag(country.getFlagName())
                .build();
    }
}
