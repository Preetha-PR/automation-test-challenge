package com.pan.utils;

import com.pan.constants.FrameworkConstants;
import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public final class DataProviderUtils {
private DataProviderUtils(){}

    private static List<Map<String, String>> list =	new ArrayList<>();
@Setter
@Getter
private static String TESTTYPE= "web";
    @DataProvider(parallel=false)
    public static Object[] getData(Method m) {
        String testname = m.getName();
        if(list.isEmpty()) {
            list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDatasheet());
        }
        List<Map<String, String>> smalllist = new ArrayList<>(list);

        Predicate<Map<String,String>> isTestNameNotMatching = map ->!map.get("Testname").equalsIgnoreCase(testname);
        Predicate<Map<String,String>> isExecuteColumnNo = map -> map.get("Execute").equalsIgnoreCase("no");

        smalllist.removeIf(isTestNameNotMatching.or(isExecuteColumnNo));
        return smalllist.toArray();

    }

}
