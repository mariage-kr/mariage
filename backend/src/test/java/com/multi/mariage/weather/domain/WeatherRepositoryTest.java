package com.multi.mariage.weather.domain;

import com.multi.mariage.common.annotation.RepositoryTest;
import com.multi.mariage.common.fixture.WeatherFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class WeatherRepositoryTest extends RepositoryTest {

    @DisplayName("날씨 정보를 저장한다.")
    @Test
    void 날씨_정보를_저장한다() {
        /* Given */
        Weather weather = WeatherFixture.맑음_현재.toWeather();

        /* When */
        Weather actual = weatherRepository.save(weather);

        /* Then */
        assertThat(actual).isEqualTo(weather);
    }

    @DisplayName("현재 날씨 정보가 있는지 조회한다.")
    @Test
    void 현재_날씨_정보가_있는지_조회한다() {
        /* Given */
        Weather weather = WeatherFixture.맑음_현재.toWeather();
        weatherRepository.save(weather);
        LocalDateTime nowDate = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        LocalDateTime date = LocalDateTime.of(nowDate.getYear(), nowDate.getMonth(), nowDate.getDayOfMonth(), nowDate.getHour(), 0, 0);

        /* When */
        boolean actual = weatherRepository.existsByDate(date);

        /* Then */
        assertThat(actual).isTrue();
    }

    @DisplayName("시간으로 날씨를 조회한다.")
    @Test
    void 시간으로_날씨를_조회한다() {
        Weather weather = WeatherFixture.맑음_현재.toWeather();
        weatherRepository.save(weather);
        LocalDateTime nowDate = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        LocalDateTime date = LocalDateTime.of(nowDate.getYear(), nowDate.getMonth(), nowDate.getDayOfMonth(), nowDate.getHour(), 0, 0);

        /* When */
        Optional<Weather> actual = weatherRepository.findByDate(date);

        /* Then */
        assertThat(actual).isNotEmpty();
    }

    @DisplayName("최신의 날씨 정보를 조회한다.")
    @Test
    void 최신의_날씨_정보를_조회한다() {
        /* Given */
        Weather weather = WeatherFixture.맑음_현재.toWeather();
        weatherRepository.save(weather);

        /* When */
        Optional<Weather> actual = weatherRepository.findLatestWeather();

        /* Then */
        assertThat(actual).isNotEmpty();
    }
}