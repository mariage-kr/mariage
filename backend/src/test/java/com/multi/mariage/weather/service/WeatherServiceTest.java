package com.multi.mariage.weather.service;

import com.multi.mariage.common.annotation.ServiceTest;
import com.multi.mariage.weather.domain.Weather;
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
}