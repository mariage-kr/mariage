package com.multi.mariage.weather.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class WeatherInfoResponse {
    private String weather;
    private String name;
    private double temp;

    @Builder
    public WeatherInfoResponse(String weather, String name, double temp) {
        this.weather = weather;
        this.name = name;
        this.temp = temp;
    }
}
