package com.multi.mariage.category.domain;

import lombok.Getter;

@Getter
public enum DrinkUpperCategory {
    LOCAL_SOJU(1, "소주", "Local"),
    LOCAL_BEER(2, "맥주", "Local"),
    LOCAL_TRADITIONAL(3, "전통주", "Local"),
    LOCAL_ETC(4, "기타", "Local"),
    FOREIGN_SPIRITS(5, "증류주", "Foreign"),
    FOREIGN_BEER(6, "맥주", "Foreign"),
    FOREIGN_WINE(7, "와인", "Foreign"),
    FOREIGN_WHISKEY(8, "위스키", "Foreign"),
    FOREIGN_ETC(9, "기타", "Foreign");
    private final int id;
    private final String name;
    private final String origin;

    DrinkUpperCategory(int id, String name, String origin) {
        this.id = id;
        this.name = name;
        this.origin = origin;
    }
}
