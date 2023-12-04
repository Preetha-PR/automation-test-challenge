package com.pan.tests.web.base;

import com.aventstack.extentreports.ExtentReports;
import com.pan.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Acts as a parent class for all the test classes in this framework.
 * All the test classes needs to extend this class. This class is responsible for invoking and terminating
 * browser under test. Invokes a new browser instance and loads the respective URL.
 * Have all the data feeded to the corresponding test method from data provider.In our case,it is
 * a hashmap containing all the values from the excel sheet.
 */
public class WebBase {
    private static final Logger logger = LogManager.getLogger(WebBase.class);
    public ExtentReports extent;

    protected WebBase() {
    }


    @BeforeMethod
    protected void setUp() {;
        Driver.initDriver();
 logger.info("Driver SetUp Initiated");
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
        logger.info("Driver Quit Successful");
    }
}
