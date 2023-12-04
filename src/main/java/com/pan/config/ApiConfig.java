package com.pan.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/api-config.properties"
})
public interface ApiConfig extends Config {

    @Key("api.baseurl")
    String apiBaseUrl();

    @Key("list.user")
    String listUserEndpoint();

    @Key("create.users")
    String postUserEndpoint();

    @Key("login.users")
    String loginUserEndPoint();
}