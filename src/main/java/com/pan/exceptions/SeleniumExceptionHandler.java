package com.pan.exceptions;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.testng.Reporter;

import static com.pan.enums.LogType.FAIL;
import static com.pan.enums.LogType.PASS;
import static com.pan.reports.FrameworkLogger.log;
public final class SeleniumExceptionHandler {
private SeleniumExceptionHandler(){}
    public static void handleException(WebDriver driver, Exception e) {
        if (e instanceof NoSuchElementException) {
            log(FAIL,"Element not found: " + e.getMessage());

        } else if (e instanceof TimeoutException) {
            log(FAIL,"Operation timed out: " + e.getMessage());
        } else if (e instanceof WebDriverException) {
            log(FAIL,"WebDriver exception: " + e.getMessage());
        }
        else {
            log(FAIL,"Unhandled exception: " + e.getMessage());
        }


    }
}