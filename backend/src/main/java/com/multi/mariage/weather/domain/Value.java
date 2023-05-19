package com.multi.mariage.weather.domain;

public enum Value {
    THUNDERSTORM("뇌우", "thunderstorm.png"),
    DRIZZLE("이슬비", "rain.png"),
    RAIN("비", "rain.png"),
    SNOW("눈", "snow.png"),
    CLEAR("맑음", "clear.png"),
    CLOUDS("흐림", "clouds.png"),
    ETC("기타", "etc.png");

    private final String name;
    private final String imageName;

    Value(String name, String imageName) {
        this.name = name;
        this.imageName = imageName;
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return "weather/" + imageName;
    }
}
