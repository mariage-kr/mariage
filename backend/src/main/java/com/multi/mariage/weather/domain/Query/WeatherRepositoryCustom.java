package com.multi.mariage.weather.domain.Query;

import com.multi.mariage.weather.domain.Weather;

import java.util.Optional;

public interface WeatherRepositoryCustom {
    Optional<Weather> findLatestWeather();
}
