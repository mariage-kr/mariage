package com.multi.mariage.weather.domain;

import com.multi.mariage.weather.domain.Query.WeatherRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<Weather, Long>, WeatherRepositoryCustom {
    boolean existsByDate(LocalDateTime date);

    Optional<Weather> findByDate(LocalDateTime date);
}
