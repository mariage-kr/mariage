package com.multi.mariage.weather.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import lombok.Getter;

@Getter
public enum WeatherErrorCode implements ErrorCode {
    OPEN_API_SERVER_ERROR(500, "WEATHER_01", "날씨 정보를 가져올 수 없습니다."),
    DB_SERVER_IS_ERROR(500, "WEATHER_02", "날씨 정보를 데이터베이스에서 조회할 수 없습니다.");

    private final int statusCode;
    private final String errorCode;
    private final String message;

    WeatherErrorCode(int statusCode, String errorCode, String message) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }
}
