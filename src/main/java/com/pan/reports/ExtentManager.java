package com.pan.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public class ExtentManager {
    /**
     * Private constructor to avoid external instantiation
     */
    private ExtentManager() {}

    private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>() ;

    /**
     * Returns the thread safe instance fetched from ThreadLocal variable.
     */
    static ExtentTest getExtentTest() {

        return extTest.get();
    }

    /**
     * Set the instance to thread local variable
     */
    static void setExtentTest(ExtentTest test) {
        if(Objects.nonNull(test)) {
            extTest.set(test);
        }
    }

    /**
     * Calling remove method on Threadlocal variable ensures to set the default value to Threadlocal variable.
     * It is much safer than assigning null value to ThreadLocal variable.
     */
    static void unload() {
        extTest.remove();
    }
}

