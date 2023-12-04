package com.pan.pages.enums.topmenucomponent;

import lombok.Getter;

@Getter
public enum SubMenuType {

    PC("PC"),
    MAC("Mac");


    private final String submenu;

    SubMenuType(String submenu) {
        this.submenu = submenu;
    }
}
