package com.pan.utils;

import com.pan.driver.manager.DriverManager;
import com.pan.exceptions.SeleniumExceptionHandler;
import com.pan.factory.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.function.Predicate;

import static com.pan.enums.LogType.PASS;
import static com.pan.reports.FrameworkLogger.log;

public class PageActionsHelper {

    private PageActionsHelper() {
    }
    static {
        DataProviderUtils.setTESTTYPE("WEB");

    }
    public static void waitWithoutClick(By by, String elementName) {

        try {
            DriverManager.getDriver().findElement(by).click();
            log(PASS,elementName+" clicked");
        } catch (Exception e) {
            SeleniumExceptionHandler.handleException(DriverManager.getDriver(), e);
        }
    }

    public static void waitAndClick(By by, String elementName) {

        try {
            ExplicitWaitFactory.waitForClickable(by).click();
            log(PASS,elementName+" clicked");
        } catch (Exception e) {
            SeleniumExceptionHandler.handleException(DriverManager.getDriver(), e);
        }
    }
    public static void waitAndClickEnter(By by, String elementName) {

        try {
            ExplicitWaitFactory.waitForClickable(by).sendKeys(Keys.ENTER);
            log(PASS,elementName+" clicked");
        } catch (Exception e) {
            SeleniumExceptionHandler.handleException(DriverManager.getDriver(), e);
        }
    }

    public static void waitAndSendKeys(By by, String value, String elementName) {
        try {
            ExplicitWaitFactory.waitForClickable(by).sendKeys(value);
            log(PASS,value+" entered in "+elementName );
        } catch (Exception e) {
            SeleniumExceptionHandler.handleException(DriverManager.getDriver(), e);
        }
    }

    public static boolean isPresent(By by, Predicate<WebElement> elementPredicate) {
        try {
            ExplicitWaitFactory.waitForPresence(by);
        } catch (Exception e) {
            SeleniumExceptionHandler.handleException(DriverManager.getDriver(), e);
        }
        return elementPredicate.test(DriverManager.getDriver().findElement(by));
    }
}
