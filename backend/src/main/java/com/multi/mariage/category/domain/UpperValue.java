package com.multi.mariage.category.domain;

import lombok.Getter;

@Getter
public enum UpperValue {
    SOJU(1, "소주"),
    BEER(2, "맥주"),
    WINE(3, "와인"),
    WHISKEY(4, "위스키"),
    TRADITIONAL(5, "전통주"),
    ETC(6, "기타");

    private final int id;
    private final String name;

    UpperValue(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
