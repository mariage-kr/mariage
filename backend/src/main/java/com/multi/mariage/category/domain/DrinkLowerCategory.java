package com.multi.mariage.category.domain;

import lombok.Getter;

import static com.multi.mariage.category.domain.DrinkUpperCategory.*;

@Getter
public enum DrinkLowerCategory {
    NORMAL_SOJU(1, LOCAL_SOJU.getId(), "희석식 소주"),
    LUXURIOUS_SOJU(2, LOCAL_SOJU.getId(), "증류식 소주"),
    FRUIT_SOJU(3, LOCAL_SOJU.getId(), "과일 소주"),
    BASIC_BEER(4, LOCAL_BEER.getId(), "일반 맥주"),
    CRAFT_BEER(5, LOCAL_BEER.getId(), "수제 맥주"),
    MAKGEOLLI(6, LOCAL_TRADITIONAL.getId(), "막걸리"),
    RICE_LIQUOR(7, LOCAL_TRADITIONAL.getId(), "약주&청주"),
    FRUIT_LIQUOR(8, LOCAL_TRADITIONAL.getId(), "과실주"),
    SOAKED_LIQUOR(9, LOCAL_TRADITIONAL.getId(), "담금주")
    ;
    private final int id;
    private final int upperId;
    private final String name;

    DrinkLowerCategory(int id, int upperId, String name) {
        this.id = id;
        this.upperId = upperId;
        this.name = name;
    }
}
