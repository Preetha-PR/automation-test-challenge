package com.pan.pages.enums.topmenucomponent;

import lombok.Getter;

@Getter
public enum MenuType {

    DESKTOPS("Desktops"),
    LAPTOPS_NOTEBOOKS("Laptops & Notebooks"),
    TABLETS("Tablets"),
    SOFTWARE("Software"),
    PHONES_PDAS("Phones & PDAs"),
    CAMERAS("Cameras"),
    MP3_PLAYERS("MP3 Players");


    private final String menu;

    MenuType(String menu) {
        this.menu = menu;
    }
}
