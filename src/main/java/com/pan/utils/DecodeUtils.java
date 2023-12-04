package com.pan.utils;

import java.util.Base64;

/**
 * Helps to decode the base64 encoded string.
 */
 public final class DecodeUtils {

    private DecodeUtils(){}
    public static String getDecodedString(String encodedString) {
        return new String(Base64.getDecoder().decode(encodedString.getBytes()));
    }

}
