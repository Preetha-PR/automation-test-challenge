package com.pan.pages;

import com.pan.pages.enums.topmenucomponent.MenuType;
import com.pan.pages.enums.topmenucomponent.SubMenuType;
import com.pan.pages.pagecomponents.homepage.SearchComponent;
import com.pan.pages.pagecomponents.homepage.TopMenuComponent;
import com.pan.pages.validators.HomePageValidator;

public class HomePage {

    private TopMenuComponent topMenuComponent;
    private SearchComponent searchcomponent;


    public HomePage(){
        this.topMenuComponent= new TopMenuComponent();
        this.searchcomponent= new SearchComponent();
    }


    public MacDesktopPage navigateMacDesktopPage(){
        topMenuComponent.clickMenuItem(MenuType.DESKTOPS)
                .clickSubMenuItem(SubMenuType.MAC);
        return new MacDesktopPage();
    }
 public MacDesktopPage searchItem(String searchItem){
        searchcomponent.keySearchItem(searchItem)
                .clickSearchButton();
        return new MacDesktopPage();
 }

    public HomePageValidator getHomePageValidator() {
        topMenuComponent.clickAccount();
        return HomePageValidator.builder()
                .isLogOutPresent(topMenuComponent.isLogOutPresent()).build();
    }
}
