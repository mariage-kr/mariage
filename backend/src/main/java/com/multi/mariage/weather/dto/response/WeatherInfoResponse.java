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
    private String imageUrl;

    @Builder
    public WeatherInfoResponse(String weather, double temp, String imageUrl) {
        this.weather = weather;
        this.temp = temp;
        this.imageUrl = imageUrl;
    }
}
