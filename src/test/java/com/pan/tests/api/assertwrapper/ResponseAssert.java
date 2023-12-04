package com.pan.tests.api.assertwrapper;

import com.pan.exceptions.InvalidPathForFilesException;
import io.restassured.response.Response;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.SoftAssertions;
import static com.pan.enums.LogType.PASS;
import static com.pan.reports.FrameworkLogger.log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Predicate;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {

    private SoftAssertions softAssertions;

    private ResponseAssert(Response response) {
        super(response, ResponseAssert.class);
        softAssertions = new SoftAssertions();
    }

    public static ResponseAssert assertThat(Response response) {
        return new ResponseAssert(response);
    }

    public ResponseAssert statusCodeIs(int expectedStatusCode) {
        softAssertions.assertThat(actual.statusCode())
                .isEqualTo(expectedStatusCode);
        log(PASS,"Status Code: "+ actual.statusCode());
        return this;
    }

    public ResponseAssert canBeDeserializedTo(Class clazz) {
        softAssertions.assertThatCode(() -> actual.as(clazz))
                .doesNotThrowAnyException();
        log(PASS,"Class successfully Deserialized");
        return this;
    }

    public ResponseAssert hasKeyWithValue(String key, String value) {
        softAssertions.assertThat(actual.getBody().jsonPath().getString(key))
                .isEqualTo(value);
        log(PASS,key+" with value "+ value +" present");
        return this;
    }

    public ResponseAssert hasKeyWithValue(Predicate<Response> predicate) {
        softAssertions.assertThat(predicate)
                .accepts(actual);
        log(PASS,"Value present");
        return this;
    }

    public ResponseAssert hasContentType(String contentType) {
        softAssertions.assertThat(actual.getContentType())
                .isEqualTo(contentType);
        log(PASS,contentType+" present");
        return this;
    }

    public ResponseAssert matchResponse(String getUser){
        String expectedJson = null;
        try {
            expectedJson = new String(Files.readAllBytes(Paths.get("src/test/resources/apitestdata/output/"+ getUser+".json")));
            softAssertions.assertThat(actual.asString()).isEqualTo(expectedJson);
            log(PASS, "Actual JSON matches the expected JSON");
        } catch (IOException e) {
            throw new InvalidPathForFilesException("Expected Output Json file Not found");
        }
        return this;
    }

    public void assertAll() {
        softAssertions.assertAll();
    }
}

