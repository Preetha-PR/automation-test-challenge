package com.pan.config.converters;

import com.pan.enums.BrowserType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowserTypeConverter implements Converter<BrowserType> {
    @Override
    public BrowserType convert(Method method, String browserName) {
        // converts provided browser value from string to enum
        //enum is used for easy manipulation
        Map<String, BrowserType> stringBrowserTypeMap = Map.
                of("CHROME", BrowserType.CHROME,
                "FIREFOX", BrowserType.FIREFOX);
        //Return default browser as Chrome if other browsers are mentioned in config properties
        return stringBrowserTypeMap.getOrDefault(browserName.toUpperCase(),BrowserType.CHROME);
    }
}
