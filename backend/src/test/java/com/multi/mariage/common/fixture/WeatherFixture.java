package com.multi.mariage.common.fixture;

import com.multi.mariage.weather.domain.Weather;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum WeatherFixture {
    맑음_현재(25.43, 800L, LocalDateTime.now(ZoneId.of("Asia/Seoul"))),
    맑음_2주전(23.13, 800L, LocalDateTime.now(ZoneId.of("Asia/Seoul")).minusWeeks(2)),
    맑음_2달전(21.13, 800L, LocalDateTime.now(ZoneId.of("Asia/Seoul")).minusMonths(2)),
    비_현재(20.43, 500L, LocalDateTime.now(ZoneId.of("Asia/Seoul")));

    private double temp;
    private Long value;
    private LocalDateTime date;

    WeatherFixture(double temp, Long value, LocalDateTime date) {
        this.temp = temp;
        this.value = value;
        this.date = date;
    }

    public Weather toWeather() {
        return Weather.builder()
                .temp(temp)
                .weatherId(value)
                .date(LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), date.getHour(), 0, 0))
                .build();
    }
}
