package com.pan.tests.api;

import com.pan.tests.api.base.BaseApi;
import com.pan.api.pojos.LoginDetails;
import com.pan.api.pojos.LoginOutputDetails;
import com.pan.api.pojos.UserDetails;
import com.pan.api.pojos.UserResponseDetails;
import com.pan.tests.api.assertwrapper.ResponseAssert;
import com.pan.utils.DataProviderUtils;
import com.pan.utils.JsonUtils;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;
import java.util.function.Predicate;

public class ApiTest {

    @Test
    public void testGetUserByIdAPI(Map<String,String> data) {
        Response response = BaseApi.getUserID();
        ResponseAssert.assertThat(response)
                .statusCodeIs(200)
                .matchResponse("get-user");
    }

    @Test
   public void testPostNewUserAPI(Map<String,String> data) {
        UserDetails userInputDetails = JsonUtils.readInputJsonFile("post-user", UserDetails.class);
        UserResponseDetails userOutputDetails = JsonUtils.readOutputJsonFile("post-useroutput", UserResponseDetails.class);
        Response response = BaseApi.postUsers(userInputDetails);

        Predicate<Response> predicate = res -> res.jsonPath()
                .getString("job")
                .equalsIgnoreCase(userOutputDetails.getJob());

        ResponseAssert.assertThat(response)
                .statusCodeIs(201)
                .canBeDeserializedTo(UserResponseDetails.class)
                .hasKeyWithValue(predicate)
                .hasContentType("application/json; charset=utf-8")
                .assertAll();
    }

    @Test
    public void testLoginAPI(Map<String,String> data) {
        LoginDetails inputLoginDetails= JsonUtils.readInputJsonFile("login-user", LoginDetails.class);
        LoginOutputDetails outputLoginDetails= JsonUtils.readOutputJsonFile("login-token", LoginOutputDetails.class);
        // Perform POST request for login
        Response response = BaseApi.loginUsers(inputLoginDetails);
        //Assertion for token
        ResponseAssert.assertThat(response)
                .hasKeyWithValue("token",outputLoginDetails.getToken());
    }
}


