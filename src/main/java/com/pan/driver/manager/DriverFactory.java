package com.pan.driver.manager;

import com.pan.driver.entity.WebDriverData;
import org.openqa.selenium.WebDriver;

public final class DriverFactory {
    private DriverFactory() {
    }
    public static WebDriver getDriver(WebDriverData driverData){
return new LocalWebDriverImpl().getDriver(driverData);

    }
}
