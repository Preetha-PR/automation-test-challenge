package com.pan.pages.pagecomponents.homepage;

import com.pan.pages.enums.topmenucomponent.MenuType;
import com.pan.pages.enums.topmenucomponent.SubMenuType;
import com.pan.utils.PageActionsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.pan.utils.PageActionsHelper.isPresent;

public class TopMenuComponent {

    private static final String MENU = "//a[text()='%s']";
    private static final String SUBMENU = "//a[text()='%s']//following-sibling::div//a[contains(text(),'%s')]";

    private static final String MYACCOUNT="//span[text()='My Account']";

    private static final String LOGOUT="//span[text()='My Account']/parent::a//following-sibling::ul//a[text()='Logout']";

    private String parentmenu= null;

    public TopMenuComponent clickMenuItem(MenuType menuType){
        parentmenu= menuType.getMenu();
        String xpath= String.format(MENU, menuType.getMenu());
        PageActionsHelper.waitAndClick(By.xpath(xpath),menuType.getMenu());
        return this;
    }

    public TopMenuComponent clickSubMenuItem(SubMenuType subMenuType){
        String xpath= String.format(SUBMENU,parentmenu,subMenuType.getSubmenu());
        PageActionsHelper.waitAndClick(By.xpath(xpath),subMenuType.getSubmenu() );
        return this;
    }

    public TopMenuComponent clickAccount(){
        PageActionsHelper.waitAndClick(By.xpath(MYACCOUNT),"My Account");
        return this;
    }

    public TopMenuComponent clickLogOut(){
        PageActionsHelper.waitAndClick(By.xpath(LOGOUT),"LogOut");
        return this;
    }

    public boolean isLogOutPresent() {
        return isPresent(By.xpath(LOGOUT), WebElement::isDisplayed);
    }
}
