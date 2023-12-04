package com.pan.factory;

import com.pan.constants.FrameworkConstants;
import com.pan.driver.manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ExplicitWaitFactory {
    private ExplicitWaitFactory(){}

private static WebElement element=null;
    public static WebElement  waitForClickable(By by){
        element= new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).
              until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }
    public static WebElement  waitForPresence(By by){
        element= new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).
                until(ExpectedConditions.presenceOfElementLocated(by));
        return element;
    }
    public static WebElement  waitForVisibility(By by){
        element= new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwait())).
                until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

}
