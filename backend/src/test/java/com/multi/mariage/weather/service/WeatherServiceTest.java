package com.multi.mariage.weather.service;

import com.multi.mariage.weather.domain.Weather;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class WeatherServiceTest {

    @Autowired
    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        weatherService.save();
    }

    @DisplayName("날씨 정보를 저장한다")
    @Test
    void 날씨_정보를_저장한다() {
        // given
        // when
        Weather actual = weatherService.save();

        // then
        assertThat(actual).isNotNull();
    }

    @DisplayName("해당 시간의 날씨 정보가 존재하는지 확인한다.")
    @Test
    void 해당_시간의_날씨_정보가_존재하는지_확인한다() {
        // given
        // when
        boolean actual = weatherService.validateWeatherTimeIsNotDuplicated();

        // then
        assertThat(actual).isTrue();
    }
}