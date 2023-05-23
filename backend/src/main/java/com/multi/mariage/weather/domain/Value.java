package com.multi.mariage.weather.domain;

public enum Value {
    THUNDERSTORM("뇌우"),
    DRIZZLE("이슬비"),
    RAIN("비"),
    SNOW("눈"),
    CLEAR("맑음"),
    CLOUDS("흐림"),
    ETC("기타");

    private final String name;

    Value(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
