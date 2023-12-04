package com.pan.listeners;

import com.pan.enums.ConfigProperties;
import com.pan.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count=0;
    private int retries = 1;
    /**
     * Return true when needs to be retried and false otherwise.
     * Maximum will retry for one time.
     * Retry will happen if user desires to and set the value in the property file
     */
    @Override
    public boolean retry(ITestResult result) {
        boolean value =false;

        if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
            value = count<retries ;
            count++;
        }
        return value;
    }
}
