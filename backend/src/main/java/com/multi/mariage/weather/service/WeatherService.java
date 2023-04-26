package com.multi.mariage.weather.service;

import com.multi.mariage.weather.domain.Weather;
import com.multi.mariage.weather.domain.WeatherRepository;
import com.multi.mariage.weather.exception.WeatherErrorCode;
import com.multi.mariage.weather.exception.WeatherException;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class WeatherService {
    private final WeatherRepository weatherRepository;

    @Value("${open.weather.key}")
    private String key;
    @Value("${open.weather.q}")
    private String q;
    @Value("${open.weather.lang}")
    private String lang;
    @Value("${open.weather.units}")
    private String units;

    @Transactional
    public Weather save() {
        String openWeatherMapApi = getOpenWeatherMapApi();

        JSONObject parse;

        try {
            JSONParser parser = new JSONParser();
            parse = (JSONObject) parser.parse(openWeatherMapApi);
        } catch (ParseException e) {
            throw new WeatherException(WeatherErrorCode.OPEN_API_SERVER_ERROR);
        }

        Weather weather = Weather.builder()
                .value(String.valueOf(getId(parse)))
                .date(getDate(parse))
                .temp(getTemp(parse))
                .build();

        return weatherRepository.save(weather);
    }

    private String getOpenWeatherMapApi() {
        WebClient webClient = WebClient
                .builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/weather?")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        return webClient.get().uri(uriBuilder -> uriBuilder
                        .queryParam("q", q)
                        .queryParam("lang", lang)
                        .queryParam("units", units)
                        .queryParam("appid", key)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private double getTemp(JSONObject json) {
        JSONObject main = (JSONObject) json.get("main");
        return (double) main.get("temp");
    }

    private Long getId(JSONObject json) {
        JSONArray weathers = (JSONArray) json.get("weather");
        JSONObject weather = (JSONObject) weathers.get(0);
        return (Long) weather.get("id");
    }

    private LocalDateTime getDate(JSONObject json) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        return LocalDateTime.parse(dateFormat.format((long) json.get("dt") * 1000), formatter);
    }
}
