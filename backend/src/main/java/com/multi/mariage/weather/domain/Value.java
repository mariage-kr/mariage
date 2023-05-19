package com.multi.mariage.weather.domain;

public enum Value {
    THUNDERSTORM("뇌우", "thunderstorm."),
    DRIZZLE("이슬비", "rain."),
    RAIN("비", "rain"),
    SNOW("눈", "snow"),
    CLEAR("맑음", "clear"),
    CLOUDS("흐림", "clouds"),
    ETC("기타", "etc");

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
