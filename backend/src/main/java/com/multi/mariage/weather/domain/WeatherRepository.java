package com.multi.mariage.weather.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
    boolean existsByDate(LocalDateTime date);
}
