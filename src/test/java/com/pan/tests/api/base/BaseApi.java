package com.pan.tests.api.base;

import com.pan.api.BaseRequestSpecification;
import com.pan.api.pojos.LoginDetails;
import com.pan.api.pojos.UserDetails;
import com.pan.factory.ApiConfigFactory;
import com.pan.listeners.ListenerClass;
import com.pan.utils.DataProviderUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class BaseApi {
    private static final Logger logger = LogManager.getLogger(BaseApi.class);
    private BaseApi(){}
static {
    DataProviderUtils.setTESTTYPE("API");

}
    private static final String LIST_USER_ENDPOINT = ApiConfigFactory.getConfig().listUserEndpoint();
    private static final String POST_USERS_ENDPOINT = ApiConfigFactory.getConfig().postUserEndpoint();

    private static final String LOGIN_USERS_ENDPOINT = ApiConfigFactory.getConfig().loginUserEndPoint();
    public static Response getUserID() {
        logger.info("Get Specific User Details using ID Method Initiated");
        return BaseRequestSpecification.getDefaultRequestSpec()
                .get(LIST_USER_ENDPOINT+"2");
    }

    public static Response postUsers(UserDetails userDetails) {
        logger.info("Post Users Method Initiated");
        return BaseRequestSpecification.getDefaultRequestSpec()
                .contentType(ContentType.JSON)
                .body(userDetails)
                .post(POST_USERS_ENDPOINT);
    }
public static Response loginUsers(LoginDetails loginDetails){
    logger.info("Login Users Method Initiated");
        return BaseRequestSpecification.getDefaultRequestSpec()
                .contentType(ContentType.JSON)
                .body(loginDetails)
                .when().post(LOGIN_USERS_ENDPOINT).then()
                .body("token",notNullValue()).extract().response();

}

}
