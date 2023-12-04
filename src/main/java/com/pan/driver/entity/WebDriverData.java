package com.pan.driver.entity;
import com.pan.enums.BrowserType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WebDriverData {
    private BrowserType browserType;
}
