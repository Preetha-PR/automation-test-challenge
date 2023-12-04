package com.pan.api.pojos;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class LoginDetails {

    private String email;
    private String password;
}
