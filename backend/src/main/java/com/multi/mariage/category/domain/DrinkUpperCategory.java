package com.multi.mariage.category.domain;

import lombok.Getter;

@Getter
public enum DrinkUpperCategory {
    LOCAL_SOJU(1, "소주", Region.LOCAL.getValue()),
    LOCAL_BEER(2, "맥주", Region.LOCAL.getValue()),
    LOCAL_TRADITIONAL(3, "전통주", Region.LOCAL.getValue()),
    LOCAL_ETC(4, "기타", Region.LOCAL.getValue()),
    FOREIGN_SPIRITS(5, "증류주", Region.FOREIGN.getValue()),
    FOREIGN_BEER(6, "맥주", Region.FOREIGN.getValue()),
    FOREIGN_WINE(7, "와인", Region.FOREIGN.getValue()),
    FOREIGN_WHISKEY(8, "위스키", Region.FOREIGN.getValue()),
    FOREIGN_ETC(9, "기타", Region.FOREIGN.getValue());
    private final int id;
    private final String name;
    private final String region;

    DrinkUpperCategory(int id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }
}
