package com.multi.mariage.category.domain;

import lombok.Getter;

@Getter
public enum FoodValue {
    CHICKEN(1, "치킨"),
    ;
    private final int id;
    private final String name;

    FoodValue(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
