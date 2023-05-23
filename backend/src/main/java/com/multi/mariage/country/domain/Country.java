package com.multi.mariage.country.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum Country {
    AMERICA(1, "미국"),
    AUSTRALIA(2, "호주"),
    AUSTRIA(3, "오스트리아"),
    BELGIUM(4, "벨기에"),
    BRAZIL(5, "브라질"),
    BULGARIA(6, "불가리아"),
    CANADA(7, "캐나다"),
    CHINA(8, "중국"),
    DENMARK(9, "덴마크"),
    ENGLAND(10, "영국"),
    ESTONIA(11, "에스토니아"),
    FINLAND(12, "핀란드"),
    FRANCE(13, "프랑스"),
    GERMANY(14, "독일"),
    GREECE(15, "그리스"),
    HUNGARY(16, "헝가리"),
    INDIA(17, "인도"),
    IRELAND(18, "아일랜드"),
    ITALY(19, "이탈리아"),
    JAPAN(20, "일본"),
    KOREA(21, "대한민국"),
    MEXICO(22, "멕시코"),
    NORWAY(23, "노르웨이"),
    PHILIPPINE(24, "필리핀"),
    POLAND(25, "폴란드"),
    RUSSIA(26, "러시아"),
    SCOTLAND(27, "스코틀랜드"),
    SPAIN(28, "스페인"),
    SWISS(29, "스위스"),
    TAIWAN(30, "대만"),
    THAILAND(31, "태국"),
    VIETNAM(32, "베트남");

    private int id;
    private String value;
    
    Country(int id, String value) {
        this.id = id;
        this.value = value;
    }
}
