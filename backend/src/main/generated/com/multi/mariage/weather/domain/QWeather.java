package com.multi.mariage.weather.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWeather is a Querydsl query type for Weather
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWeather extends EntityPathBase<Weather> {

    private static final long serialVersionUID = 1662396000L;

    public static final QWeather weather = new QWeather("weather");

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> temp = createNumber("temp", Double.class);

    public final StringPath value = createString("value");

    public QWeather(String variable) {
        super(Weather.class, forVariable(variable));
    }

    public QWeather(Path<? extends Weather> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWeather(PathMetadata metadata) {
        super(Weather.class, metadata);
    }

}

