package com.multi.mariage.weather.controller;

import com.multi.mariage.weather.dto.response.WeatherInfoResponse;
import com.multi.mariage.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather/info")
    public ResponseEntity<WeatherInfoResponse> findInfo() {
        WeatherInfoResponse response = weatherService.findInfo();
        return ResponseEntity.ok(response);
    }
}
