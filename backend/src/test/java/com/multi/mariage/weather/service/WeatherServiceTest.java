package com.multi.mariage.weather.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.weather.domain.Weather;
import com.multi.mariage.weather.dto.response.WeatherInfoResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WeatherServiceTest extends ServiceTest {
    @DisplayName("최신 정보를 저장한다.")
    @Test
    void 날씨_정보를_저장한다() {
        Weather actual = weatherService.findLatestWeather();

        assertThat(actual).isNotNull();
    }

    @DisplayName("현재 날씨 정보를 조회한다.")
    @Test
    void 현재_날씨_정보를_조회한다() {
        /* Given */
        /* When */
        WeatherInfoResponse actual = weatherService.findInfo();

        /* Then */
        assertThat(actual).isNotNull();
    }
}