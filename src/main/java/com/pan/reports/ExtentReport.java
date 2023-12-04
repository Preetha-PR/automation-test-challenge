package com.pan.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.pan.constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}
    private static ExtentReports extent;

    /**
     * Set the initial configuration
     */
    public static void initReports() {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Demo Test Report");
            spark.config().setReportName("Demo Test Report");
        }
    }
    /**
     * Creates a test node in the extent report. Delegates to {@link ExtentManager} for providing thread safety
     * testcasename Test Name that needs to be reflected in the report
     */
    public static void createTest(String testcasename) {

        ExtentManager.setExtentTest(extent.createTest(testcasename));
    }
    /**
     * Flushing the reports ensures extent logs are reflected properly.
     * Opens the report in the default desktop browser.
     * Sets the ThreadLocal variable to default value
     */
    public static void flushReports(){
        if(Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
