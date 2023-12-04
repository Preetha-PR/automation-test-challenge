package com.pan.driver.manager;


import com.pan.factory.BrowserDriverFactory;
import com.pan.driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public class LocalWebDriverImpl implements IWebDriver{
    @Override
    public WebDriver getDriver(WebDriverData driverData) {
        return BrowserDriverFactory.getDriver(driverData.getBrowserType());
    }
}
