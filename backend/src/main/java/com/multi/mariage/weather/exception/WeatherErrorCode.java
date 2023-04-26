package com.multi.mariage.weather.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public enum WeatherErrorCode implements ErrorCode {
    OPEN_API_SERVER_ERROR(500, "WEATHER_01", "날씨 정보를 가져올 수 없습니다.");

    private final int statusCode;
    private final String errorCode;
    private final String message;

    WeatherErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
