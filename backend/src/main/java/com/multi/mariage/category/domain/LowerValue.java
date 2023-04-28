package com.multi.mariage.category.domain;

import lombok.Getter;

import static com.multi.mariage.category.domain.UpperValue.LOCAL_SOJU;

@Getter
public enum LowerValue {
    NORMAL_SOJU(1, LOCAL_SOJU.getId(), "희석식 소주"),
    LUXURIOUS_SOJU(2, LOCAL_SOJU.getId(), "증류식 소주"),
    FRUIT_SOJU(3, LOCAL_SOJU.getId(), "과일 소주");
    private final int id;
    private final int upperId;
    private final String name;

    LowerValue(int id, int upperId, String name) {
        this.id = id;
        this.upperId = upperId;
        this.name = name;
    }
}
