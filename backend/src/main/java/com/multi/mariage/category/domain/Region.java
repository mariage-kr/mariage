package com.multi.mariage.category.domain;

import lombok.Getter;

@Getter
public enum Region {
    LOCAL("국내"), FOREIGN("해외");

    private final String value;

    Region(String value) {

        this.value = value;
    }
}
