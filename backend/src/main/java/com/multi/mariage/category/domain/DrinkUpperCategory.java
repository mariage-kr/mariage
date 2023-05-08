package com.multi.mariage.category.domain;

import lombok.Getter;

@Getter
public enum DrinkUpperCategory {
    LOCAL_SOJU(1, "국내 소주", Region.LOCAL.getValue()),
    LOCAL_BEER(2, "국내 맥주", Region.LOCAL.getValue()),
    LOCAL_TRADITIONAL(3, "국내 전통주", Region.LOCAL.getValue()),
    LOCAL_ETC(4, "국내 기타", Region.LOCAL.getValue()),
    FOREIGN_SPIRITS(5, "해외 증류주", Region.FOREIGN.getValue()),
    FOREIGN_BEER(6, "해외 맥주", Region.FOREIGN.getValue()),
    FOREIGN_WINE(7, "해외 와인", Region.FOREIGN.getValue()),
    FOREIGN_WHISKEY(8, "해외 위스키", Region.FOREIGN.getValue()),
    FOREIGN_ETC(9, "해외 기타", Region.FOREIGN.getValue());
    private final int id;
    private final String name;
    private final String region;

    DrinkUpperCategory(int id, String name, String region) {
        this.id = id;
        this.name = name;
        this.region = region;
    }
}
