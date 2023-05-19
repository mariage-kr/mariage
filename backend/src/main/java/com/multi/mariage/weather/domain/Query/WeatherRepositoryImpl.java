package com.multi.mariage.weather.domain.Query;

import com.multi.mariage.weather.domain.QWeather;
import com.multi.mariage.weather.domain.Weather;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class WeatherRepositoryImpl implements WeatherRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public WeatherRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Optional<Weather> findLatestWeather() {
        Weather weather = queryFactory
                .selectFrom(QWeather.weather)
                .orderBy(QWeather.weather.id.desc())
                .limit(1)
                .fetchOne();

        return Optional.ofNullable(weather);
    }
}
