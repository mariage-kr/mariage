package com.multi.mariage.category.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public enum DrinkUpperCategory {
    LOCAL_SOJU(1, "소주", "local"),
    LOCAL_BEER(2, "맥주", "local"),
    LOCAL_TRADITIONAL(3, "전통주", "local"),
    LOCAL_ETC(4, "기타", "local"),
    FOREIGN_SPIRITS(5, "증류주", "foreign"),
    FOREIGN_BEER(6, "맥주", "foreign"),
    FOREIGN_WINE(7, "와인", "foreign"),
    FOREIGN_WHISKEY(8, "위스키", "foreign"),
    FOREIGN_ETC(9, "기타", "foreign");
    private final int id;
    private final String name;
    private final String region;

    DrinkUpperCategory(int id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }
}
