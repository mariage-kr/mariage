package com.multi.mariage.category.domain;

import lombok.Getter;

import static com.multi.mariage.category.domain.DrinkUpperCategory.*;

@Getter
public enum DrinkLowerCategory {
    NORMAL_SOJU(1, LOCAL_SOJU.getId(), "희석식 소주"),
    LUXURIOUS_SOJU(2, LOCAL_SOJU.getId(), "증류식 소주"),
    FRUIT_SOJU(3, LOCAL_SOJU.getId(), "과일 소주"),
    BASIC_BEER(4, LOCAL_BEER.getId(), "일반 맥주"),
    CRAFT_BEER(5, LOCAL_BEER.getId(), "수제 맥주"),
    MAKGEOLLI(6, LOCAL_TRADITIONAL.getId(), "막걸리"),
    CLEAR_LIQUOR(7, LOCAL_TRADITIONAL.getId(), "약주 & 청주"),
    FRUIT_LIQUOR(8, LOCAL_TRADITIONAL.getId(), "과실주"),
    SOAKED_LIQUOR(9, LOCAL_TRADITIONAL.getId(), "담금주"),
    DOMESTIC_WINE(10, LOCAL_ETC.getId(), "국산 와인"),
    DOMESTIC_WHISKEY(11, LOCAL_ETC.getId(), "국산 위스키"),
    JAPANESE_SHOCHU(12, FOREIGN_SPIRITS.getId(), "일본 소주"),
    KAOLIANG_LIQUOR(13, FOREIGN_SPIRITS.getId(), "고량주"),
    VODKA(14, FOREIGN_SPIRITS.getId(), "보드카 & 진"),
    ALE(15, FOREIGN_BEER.getId(), "에일"),
    LAGER(16, FOREIGN_BEER.getId(), "라거"),
    DARK_BEER(17, FOREIGN_BEER.getId(), "흑맥주"),
    WHITE_WINE(18, FOREIGN_WINE.getId(), "화이트 와인"),
    ROSE_WINE(19, FOREIGN_WINE.getId(), "로제 와인"),
    RED_WINE(20, FOREIGN_WINE.getId(), "레드 와인"),
    SPARKLING_WINE(21, FOREIGN_WINE.getId(), "스파클링 와인"),
    DESSERT_WINE(22, FOREIGN_WINE.getId(), "디저트 와인"),
    FORTIFIED_WINE(23, FOREIGN_WINE.getId(), "강화 와인"),
    MALT_WHISKY(24, FOREIGN_WHISKEY.getId(), "몰트 위스키"),
    BLENDED_WHISKEY(25, FOREIGN_WHISKEY.getId(), "블렌디드 위스키"),
    GRAIN_WHISKY(26, FOREIGN_WHISKEY.getId(), "그레인 위스키"),
    SCOTCH_WHISKY(27, FOREIGN_WHISKEY.getId(), "스카치 위스키"),
    IRISH_WHISKEY(28, FOREIGN_WHISKEY.getId(), "아이리쉬 위스키"),
    BOURBON_WHISKEY(29, FOREIGN_WHISKEY.getId(), "버번(아메리칸) 위스키"),
    CANADIAN_WHISKY(30, FOREIGN_WHISKEY.getId(), "캐나디안 위스키"),
    JAPANESE_WHISKEY(31, FOREIGN_WHISKEY.getId(), "재패니즈 위스키"),
    PORT_WHISKY(32, FOREIGN_WHISKEY.getId(), "포트 위스키"),
    PATENT_WHISKEY(33, FOREIGN_WHISKEY.getId(), "페이턴트 위스키"),
    ETC_WHISKEY(34, FOREIGN_WHISKEY.getId(), "기타"),
    SAKE(35, FOREIGN_ETC.getId(), "사케"),
    BAIJIU(36, FOREIGN_ETC.getId(), "백주"),
    BRANDY(37, FOREIGN_ETC.getId(), "브랜디(꼬냑)"),
    RUM(38, FOREIGN_ETC.getId(), "럼"),
    TEQUILA(39, FOREIGN_ETC.getId(), "데킬라"),
    LIQUEUR(40, FOREIGN_ETC.getId(), "리큐르"),
    CHAMPAGNE(41, FOREIGN_ETC.getId(), "샴페인"),
    OTHERS(42, FOREIGN_ETC.getId(), "그 외")
    ;
    private final int id;
    private final int upperId;
    private final String name;

    DrinkLowerCategory(int id, int upperId, String name) {
        this.id = id;
        this.upperId = upperId;
        this.name = name;
    }
}
