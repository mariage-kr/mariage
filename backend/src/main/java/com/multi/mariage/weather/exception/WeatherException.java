package com.multi.mariage.weather.exception;

import com.multi.mariage.global.exception.exception.ErrorCode;
import com.multi.mariage.global.exception.exception.MariageException;

public class WeatherException extends MariageException {
    public WeatherException(ErrorCode code) {
        super(code);
    }
}
