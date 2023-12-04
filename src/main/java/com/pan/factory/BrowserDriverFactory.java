package com.pan.factory;

import com.pan.driver.manager.ChromeManager;
import com.pan.driver.manager.FirefoxManager;
import com.pan.driver.manager.IWebDriver;
import com.pan.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;


//Final class to restrict inheritance by other classes
public final class BrowserDriverFactory {

    private BrowserDriverFactory() {
    }

    private static final Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);

    static {
        MAP.put(BrowserType.CHROME, ChromeManager::getDriver);
        MAP.put(BrowserType.FIREFOX, FirefoxManager::getDriver);
    }

    public static WebDriver getDriver(BrowserType browserType) {
        return MAP.get(browserType).get();
    }
}
