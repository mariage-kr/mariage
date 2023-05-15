package com.multi.mariage.country.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum Country {
    //TODO: 추후 나라 추가
    KOREA(1, "대한민국", "korea"),
    USA(2, "미국", "usa"),
    JAPAN(3, "일본", "japan"),
    CHINA(4, "중국", "china");

    private int id;
    private String country;
    private String flagName;


    Country(int id, String country, String flagName) {
        this.id = id;
        this.country = country;
        this.flagName = flagName;
    }
}
