package org.fundacionjala.pivotal.pages;

import org.fundacionjala.pivotal.help.CommonActions;
import org.fundacionjala.pivotal.help.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Administrator on 5/25/2017.
 */
public class SignIn extends AbstractBasePage {

    @FindBy(id = "credentials_username")
    @CacheLookup
    WebElement usernameTextField;

    @FindBy(css = ".app_signin_action_button")
    @CacheLookup
    WebElement nextButton;

    @FindBy(id = "credentials_password")
    @CacheLookup
    WebElement passwordTextField;

    @FindBy(css = ".app_signin_action_button")
    @CacheLookup
    WebElement loginButton;
    private String url;

    public void setUserNameTextField(String mail) {
        CommonActions.setTextField(usernameTextField, mail);
    }

    public void setPasswordTextField(String password) {
        CommonActions.setTextField(passwordTextField, password);
    }

    public void clickNextButton() {
        CommonActions.clickElement(nextButton);
    }

    public DashBoard clickLoginButton() {
        CommonActions.clickElement(loginButton);
        return new DashBoard();
    }

    public void setUrl(String url) {
        DriverManager.getInstance().setUrl(url);
    }
}
