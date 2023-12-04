package com.pan.api.pojos;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class LoginOutputDetails {

    private String token;
}
