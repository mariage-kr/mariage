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
import java.util.Optional;
import java.util.TimeZone;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class WeatherService {
    private static final String PATTERN = "yyyy-MM-dd HH";
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
    public Weather findLatestWeather() {
        LocalDateTime now = getFormatLocalDateTime(System.currentTimeMillis());

        /* 1. 최신 날씨 정보가 있으면 반환 */
        if (validateNowWeatherIsExisted()) {
            return weatherRepository.findByDate(now)
                    .orElseThrow(() -> new WeatherException(WeatherErrorCode.OPEN_API_SERVER_ERROR));
        }

        Weather newWeather = byOpenWeatherApi();
        Optional<Weather> latestWeather = weatherRepository.findLatestWeather();

        /* 2. DB에 날씨 정보가 1개도 없으면 새로운 날씨 데이터를 저장 후 반환 */
        if (latestWeather.isEmpty()) {
            return weatherRepository.save(newWeather);
        }

        /* 3. OPEN API 의 갱신문제로 인하여 최신 정보를 못 가져올 경우 DB에 있는 최신 정보를 반환 */
        if (isEqualsDate(newWeather, latestWeather.get())) {
            return latestWeather.get();
        }

        /* 4. OPEN API 의 날씨 정보가 최신이면 해당 날씨를 저장 후 반환 */
        return weatherRepository.save(newWeather);
    }

    /* TODO: 테스트 관련 내용으로 인해서 접근 제어라를 public 로 하는 행위는 좋지 않으므로 수정 한다. */
    public boolean validateNowWeatherIsExisted() {
        LocalDateTime date = getFormatLocalDateTime(System.currentTimeMillis());
        return weatherRepository.existsByDate(date);
    }

    private boolean isEqualsDate(Weather newWeather, Weather latestWeather) {
        return newWeather.getDate().isEqual(latestWeather.getDate());
    }

    private Weather byOpenWeatherApi() {
        String openWeatherMapApi = getOpenWeatherMapApi();

        JSONObject json;

        try {
            JSONParser parser = new JSONParser();
            json = (JSONObject) parser.parse(openWeatherMapApi);
        } catch (ParseException e) {
            throw new WeatherException(WeatherErrorCode.OPEN_API_SERVER_ERROR);
        }

        return Weather.builder()
                .weatherId(getId(json))
                .date(getDate(json))
                .temp(getTemp(json))
                .build();
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
        JSONObject weather = (JSONObject) weathers.get(weathers.size() - 1);
        return (Long) weather.get("id");
    }

    private LocalDateTime getDate(JSONObject json) {
        return getFormatLocalDateTime((long) json.get("dt") * 1000);
    }

    private LocalDateTime getFormatLocalDateTime(Long date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN);
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

        return LocalDateTime.parse(dateFormat.format(date), formatter);
    }
}
