package com.multi.mariage.common.fixture;

import com.multi.mariage.weather.domain.Weather;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum WeatherFixture {
    맑음(25.43, 800L, LocalDateTime.of(2023, 5, 17, 23, 0, 0));

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
                .date(date)
                .build();
    }
}
