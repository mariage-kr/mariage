package com.multi.mariage.category.domain;

import lombok.Getter;

@Getter
public enum FoodCategory {
    SEAFOOD(1, "해산물"),
    ROAST(2, "고기/구이"),
    JOKBAL(3, "족발/보쌈"),
    JJIGAE(4, "찜/탕/찌개"),
    RICE(5, "밥/면"),
    PIZZA(6, "피자"),
    CHICKEN(7, "치킨"),
    ITALIAN(8, "양식"),
    CHINESE(9, "중식"),
    JAPANESE(10, "돈까스/회/일식"),
    ASIAN(11, "아시안"),
    MEXICAN(12, "멕시코"),
    BURGER(13, "햄버거"),
    BUNSIK(14, "분식"),
    FRIES(15, "튀김"),
    SNACK(16, "스낵"),
    CHEESE(17, "치즈"),
    FRUIT(18, "과일"),
    DESSERT(19, "디저트"),
    ETC(20, "기타");
    private final Integer id;
    private final String name;

    FoodCategory(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
