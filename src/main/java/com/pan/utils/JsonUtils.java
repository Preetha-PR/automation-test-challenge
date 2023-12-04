package com.pan.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

public final class JsonUtils {
    private JsonUtils(){}
    private static final ObjectMapper objectMapper = new ObjectMapper();
    @SneakyThrows
    public static <T> T readInputJsonFile(String filename, Class<T> valueType) {
        return objectMapper.readValue(new File( System.getProperty("user.dir") + "/src/test/resources/apitestdata/input/"+ filename+".json"), valueType);
    }

    @SneakyThrows
    public static <T> T readOutputJsonFile(String filename, Class<T> valueType) {
        return objectMapper.readValue(new File( System.getProperty("user.dir") + "/src/test/resources/apitestdata/output/"+ filename+".json"), valueType);
    }
}
