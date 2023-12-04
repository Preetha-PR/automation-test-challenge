package com.pan.pages;

import com.pan.utils.PageActionsHelper;
import org.openqa.selenium.By;

public class LoginPage{
    private static final By USER_EMAIL_TEXT_BOX = By.id("input-email");
    private static final By PASSWORD_TEXT_BOX = By.id("input-password");
    private static final By LOGIN_BUTTON = By.id("input-email");

    private LoginPage setUserEmailTextBox(String userEmail) {
       PageActionsHelper.waitAndSendKeys(USER_EMAIL_TEXT_BOX, userEmail, "UserEmail");
       return this;
    }
    private LoginPage setPasswordTextBox(String password){
        PageActionsHelper.waitAndSendKeys(PASSWORD_TEXT_BOX, password, "Password");
        return this;
    }
    private HomePage clickLoginButton(){
        PageActionsHelper.waitAndClickEnter(LOGIN_BUTTON, "Login Button");
        return new HomePage();
     }


public HomePage loginToApplication(String userEmail, String password){
return setUserEmailTextBox(userEmail)
            .setPasswordTextBox(password)
            .clickLoginButton();
}
}
