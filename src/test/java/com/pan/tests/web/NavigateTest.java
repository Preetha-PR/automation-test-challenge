package com.pan.tests.web;


import com.pan.pages.LoginPage;
import com.pan.pages.MacDesktopPage;
import com.pan.tests.web.base.WebBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Test Name should match the column name "testname" in excel sheet to run the test.
 * The match has to be there in both of the TESTMANAGER and TESTDATA sheet.
 * Set the authors who have the created the test which will be logged to the reports.
 * Set the category which this particular test case belongs to
 * HashMap containing all the values of test data needed to run the tests
 */
public final class NavigateTest extends WebBase {

    private NavigateTest(){}
    @Test
    public void testMacNavigation(Map<String,String> data){
        MacDesktopPage macDesktopPage = new LoginPage()
                .loginToApplication(data.get("username"),data.get("password"))
                .navigateMacDesktopPage();

        Assert.assertTrue(macDesktopPage.isMacPresent());
    }
}

