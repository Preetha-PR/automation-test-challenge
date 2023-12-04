package com.pan.constants;


import com.pan.enums.ConfigProperties;
import com.pan.utils.PropertyUtils;

public final class FrameworkConstants {
    private FrameworkConstants(){}
    private static final int EXPLICITWAIT = 30;
    private static final String RESOURCESPATH =  System.getProperty("user.dir")+"/src/test/resources";
    private static final String EXCELPATH = RESOURCESPATH+"/testmanager.xlsx";
    private static final String CONFIGFILEPATH = RESOURCESPATH+"/config.properties";
    private static final String TESTMANAGERSHEET = "TestCaseManager";
    private static final String ITERATIONDATASHEET = "TestData";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/";
    private static String extentReportFilePath = "";


    public static String getExtentReportFilePath()  {
        if(extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }
    private static String createReportPath()  {
        if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
        }
        else {
            return EXTENTREPORTFOLDERPATH+"/index.html";
        }
    }
    public static String getExcelpath() {
        return EXCELPATH;
    }

    public static int getExplicitwait() {
        return EXPLICITWAIT;
    }

    public static String getTestmanagersheet() {
        return TESTMANAGERSHEET;
    }

    public static String getIterationDatasheet() {
        return ITERATIONDATASHEET;
    }

    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }

}
