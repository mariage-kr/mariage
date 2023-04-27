package com.multi.mariage.weather.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWeather is a Querydsl query type for Weather
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWeather extends EntityPathBase<Weather> {

    private static final long serialVersionUID = 1662396000L;

    public static final QWeather weather = new QWeather("weather");

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.multi.mariage.review.domain.Review, com.multi.mariage.review.domain.QReview> reviews = this.<com.multi.mariage.review.domain.Review, com.multi.mariage.review.domain.QReview>createList("reviews", com.multi.mariage.review.domain.Review.class, com.multi.mariage.review.domain.QReview.class, PathInits.DIRECT2);

    public final NumberPath<Double> temp = createNumber("temp", Double.class);

    public final EnumPath<Value> value = createEnum("value", Value.class);

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

