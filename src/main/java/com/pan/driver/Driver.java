package com.pan.driver;

import static com.pan.factory.ConfigFactory.getconfig;
import com.pan.driver.entity.WebDriverData;
import com.pan.driver.manager.DriverFactory;
import com.pan.driver.manager.DriverManager;
import com.pan.exceptions.BrowserInvocationFailedException;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public final class Driver {

    private Driver() {
    }

    public static void initDriver() {

        if (Objects.isNull(DriverManager.getDriver())) {
            try{
            WebDriverData driverData = WebDriverData.builder().browserType(getconfig().browser()).build();
            WebDriver driver = DriverFactory.getDriver(driverData);
            DriverManager.setDriver(driver);
            }
            catch (Exception e) {
                throw new BrowserInvocationFailedException("Please check the capabilities of browser");
            }
            loadURL();
        }
    }

    public static void loadURL() {
        DriverManager.getDriver().get(getconfig().webURL());
        DriverManager.getDriver().manage().window().maximize();
    }

    public static void quitDriver() {
// quit driver
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
