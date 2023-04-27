package com.multi.mariage.category.domain;

import lombok.Getter;

@Getter
public enum UpperValue {
    LOCAL_SOJU(1, "국내 소주"),
    LOCAL_BEER(2, "국내 맥주"),
    LOCAL_TRADITIONAL(3, "국내 전통주"),
    LOCAL_ETC(4, "국내 기타"),
    FOREIGN_SPIRITS(6, "해외 증류주"),
    FOREIGN_BEER(6, "해외 맥주"),
    FOREIGN_WINE(7, "해외 와인"),
    FOREIGN_WHISKEY(8, "해외 위스키"),
    FOREIGN_ETC(9, "해외 기타");
    private final String name;
    private final int id;

    UpperValue(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
