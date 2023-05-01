package com.multi.mariage.global.exception.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ExceptionResponse {
    private final String message;

    public static ExceptionResponse from(String message) {
        return new ExceptionResponse(message);
    }
}
