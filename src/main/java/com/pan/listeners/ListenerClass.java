package com.pan.listeners;

import com.pan.reports.ExtentReport;
import org.testng.*;
import java.util.Arrays;
import static com.pan.enums.LogType.*;
import static com.pan.reports.FrameworkLogger.log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Implements ITest and ISuite Listener to leverage the abstract methods
 * Used in extent report generation
 * listener details added in the testng.xml file
 */
public class ListenerClass implements ITestListener, ISuiteListener {
    /**
     * Initialise the reports with the file name
     */
    private static final Logger logger = LogManager.getLogger(ListenerClass.class);
    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReports();
        logger.info("Initiating Extent Report Creation");
    }

    /**
     * Terminate the reports
     */
    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.flushReports();
        logger.info("Flushing Extent Report");
    }

    /**
     * Starts a test node for each testng test
     */
    @Override
    public void onTestStart(ITestResult result) {

        ExtentReport.createTest(result.getMethod().getDescription());
    }

    /**
     * Marks the test as pass and logs it in the report
     */
    @Override
    public void onTestSuccess(ITestResult result) {

        log(PASS,result.getMethod().getMethodName() +" is passed");
    }

    /**
     * Marks the test as fail,append base64 screenshot and logs it in the report
     */
    @Override
    public void onTestFailure(ITestResult result) {
        log(FAIL,result.getMethod().getMethodName() +" is failed");
        log(FAIL,result.getThrowable().toString());
        log(FAIL, Arrays.toString(result.getThrowable().getStackTrace()));
    }

    /**
     * Marks the test as skip and logs it in the report
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        log(SKIP,result.getMethod().getMethodName() +" is skipped");
    }
}
