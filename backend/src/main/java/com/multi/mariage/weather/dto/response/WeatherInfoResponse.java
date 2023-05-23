package com.multi.mariage.weather.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class WeatherInfoResponse {
    private String weather;
    private double temp;

    @Builder
    public WeatherInfoResponse(String weather, double temp) {
        this.weather = weather;
        this.temp = temp;
    }
}
