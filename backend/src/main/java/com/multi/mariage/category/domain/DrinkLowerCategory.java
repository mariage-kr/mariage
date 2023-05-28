package com.multi.mariage.category.domain;

import lombok.Getter;

import static com.multi.mariage.category.domain.DrinkUpperCategory.*;

@Getter
public enum DrinkLowerCategory {
    NORMAL_SOJU(1, "희석식 소주", LOCAL_SOJU),
    LUXURIOUS_SOJU(2, "증류식 소주", LOCAL_SOJU),
    FRUIT_SOJU(3, "과일 소주", LOCAL_SOJU),
    BASIC_BEER(4, "일반 맥주", LOCAL_BEER),
    CRAFT_BEER(5, "수제 맥주", LOCAL_BEER),
    MAKGEOLLI(6, "막걸리", LOCAL_TRADITIONAL),
    CLEAR_LIQUOR(7, "약주 & 청주", LOCAL_TRADITIONAL),
    FRUIT_LIQUOR(8, "과실주", LOCAL_TRADITIONAL),
    SOAKED_LIQUOR(9, "담금주", LOCAL_TRADITIONAL),
    DOMESTIC_WINE(10, "국산 와인", LOCAL_ETC),
    DOMESTIC_WHISKEY(11, "국산 위스키", LOCAL_ETC),
    JAPANESE_SHOCHU(12, "일본 소주", FOREIGN_SPIRITS),
    BAIJIU(13, "백주", FOREIGN_SPIRITS),
    VODKA(14, "보드카 & 진", FOREIGN_SPIRITS),
    ALE(15, "에일", FOREIGN_BEER),
    LAGER(16, "라거", FOREIGN_BEER),
    DARK_BEER(17, "흑맥주", FOREIGN_BEER),
    WHITE_WINE(18, "화이트 와인", FOREIGN_WINE),
    ROSE_WINE(19, "로제 와인", FOREIGN_WINE),
    RED_WINE(20, "레드 와인", FOREIGN_WINE),
    SPARKLING_WINE(21, "스파클링 와인", FOREIGN_WINE),
    DESSERT_WINE(22, "디저트 와인", FOREIGN_WINE),
    FORTIFIED_WINE(23, "강화 와인", FOREIGN_WINE),
    SINGLEMALT_WHISKY(24, "싱글몰트 위스키", FOREIGN_WHISKEY),
    BLENDEDMALT_WHISKEY(25, "블렌디드몰트 위스키", FOREIGN_WHISKEY),
    BLENDED_WHISKEY(26, "블렌디드 위스키", FOREIGN_WHISKEY),
    GRAIN_WHISKY(27, "그레인 위스키", FOREIGN_WHISKEY),
    IRISH_WHISKEY(28, "아이리시 위스키", FOREIGN_WHISKEY),
    BOURBON_WHISKEY(29, "버번(아메리칸) 위스키", FOREIGN_WHISKEY),
    CANADIAN_WHISKY(30, "캐나디안 위스키", FOREIGN_WHISKEY),
    JAPANESE_WHISKEY(31, "재패니즈 위스키", FOREIGN_WHISKEY),
    PORT_WHISKY(32, "포트 위스키", FOREIGN_WHISKEY),
    PATENT_WHISKEY(33, "페이턴트 위스키", FOREIGN_WHISKEY),
    ETC_WHISKEY(34, "기타", FOREIGN_WHISKEY),
    SAKE(35, "사케", FOREIGN_ETC),
    HUANGJIU(36, "중국황주", FOREIGN_ETC),
    BRANDY(37, "브랜디(꼬냑)", FOREIGN_ETC),
    RUM(38, "럼", FOREIGN_ETC),
    TEQUILA(39, "데킬라", FOREIGN_ETC),
    LIQUEUR(40, "리큐르", FOREIGN_ETC),
    CIDER(41, "사이더", FOREIGN_ETC),
    OTHERS(42, "그 외", FOREIGN_ETC);
    private final int id;
    private final String name;
    private final DrinkUpperCategory upperType;

    DrinkLowerCategory(int id, String name, DrinkUpperCategory upperType) {
        this.id = id;
        this.name = name;
        this.upperType = upperType;
    }
}
