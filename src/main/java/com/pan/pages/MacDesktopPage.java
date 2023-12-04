package com.pan.pages;

import com.pan.pages.validators.HomePageValidator;
import com.pan.utils.PageActionsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.pan.utils.PageActionsHelper.isPresent;

public class MacDesktopPage {

    private static final String MAC_PRESENCE="//h2[text()='Mac']";
    private static final String MAC_SEARCH="//a[text()='iMac']";
    public boolean isMacPresent() {
        return isPresent(By.xpath(MAC_PRESENCE), WebElement::isDisplayed);
    }

    public boolean isMacSearchPresent() {
        return isPresent(By.xpath(MAC_SEARCH), WebElement::isDisplayed);
    }

}
