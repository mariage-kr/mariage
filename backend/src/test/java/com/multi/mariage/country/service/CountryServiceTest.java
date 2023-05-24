package com.multi.mariage.country.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.country.dto.response.CountryResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountryServiceTest extends ServiceTest {

    @DisplayName("제조국을 조회한다.")
    @Test
    void 제조국을_조회한다() {
        // given
        // when
        CountryResponse countries = countryService.findCountries();

        // then
        countries.getCountry().forEach(country -> assertThat(country).isNotNull());
    }
}