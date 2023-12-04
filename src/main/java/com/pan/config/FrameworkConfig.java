package com.pan.config;

import com.pan.config.converters.StringToBrowserTypeConverter;
import com.pan.enums.BrowserType;
import org.aeonbits.owner.Config;
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties"
})
public interface FrameworkConfig extends Config {
@DefaultValue("staging")
String environment();

@Key("${environment}.webURL")
String webURL();


    //use custom written StringToBrowserTypeConverter converter class
    //for converting given string to enum
    @DefaultValue("CHROME")
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();
}
