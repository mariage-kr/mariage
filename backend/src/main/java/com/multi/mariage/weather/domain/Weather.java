package com.multi.mariage.weather.domain;

import com.multi.mariage.review.domain.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Weather {
    @OneToMany(mappedBy = "weather")
    private final List<Review> reviews = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private Long id;
    @Column(nullable = false)
    private double temp;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Value value;

    @Column(nullable = false)
    private LocalDateTime date;

    @Builder
    public Weather(double temp, Long weatherId, LocalDateTime date) {
        this.temp = temp;
        this.value = setValue(weatherId);
        this.date = date;
    }

    private Value setValue(Long weatherId) {
        if (weatherId / 100 == 2) {
            return Value.THUNDERSTORM;
        }
        if (weatherId / 100 == 3) {
            return Value.DRIZZLE;
        }
        if (weatherId / 100 == 5) {
            return Value.RAIN;
        }
        if (weatherId / 100 == 6) {
            return Value.SNOW;
        }
        if (weatherId == 800) {
            return Value.CLEAR;
        }
        return Value.CLOUDS;
    }
}
