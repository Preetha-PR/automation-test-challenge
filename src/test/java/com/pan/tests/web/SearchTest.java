package com.pan.tests.web;

import com.pan.pages.LoginPage;
import com.pan.pages.MacDesktopPage;
import com.pan.tests.web.base.WebBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public final class SearchTest extends WebBase {

    private SearchTest(){}
    @Test
    public void testSearch(Map<String,String> data){
        MacDesktopPage macDesktopPage =  new LoginPage()
                .loginToApplication(data.get("username"),data.get("password"))
                .searchItem("iMac");
        Assert.assertTrue(macDesktopPage.isMacSearchPresent());
    }
}
