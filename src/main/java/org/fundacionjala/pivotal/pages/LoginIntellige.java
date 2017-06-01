package org.fundacionjala.pivotal.pages;

import org.fundacionjala.pivotal.help.LoadProperties;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 5/30/2017.
 */
public class LoginIntellige extends AbstractBasePage {
    @FindBy(css = ".tc_dropdown_name")
    @CacheLookup
    private  WebElement userInLink;

    public  DashBoard verifyTheLoginOfUser() {

        DashBoard dashBoard = null;
        try {
            if( userInLink.getText().toString() !=null)
            {
                 dashBoard = new DashBoard();
                 dashBoard.webDriver.get("https://www.pivotaltracker.com/dashboard");
            }
            //irwe al loggeo
        }catch (WebDriverException webDriveException){
            SignIn initSignIn = new SignIn();
            initSignIn.webDriver.get("https://www.pivotaltracker.com/signin");
            initSignIn.setUserNameTextField(LoadProperties.user.getProperty("testerAt03.username"));
            initSignIn.clickNextButton();
            initSignIn.setPasswordTextField(LoadProperties.user.getProperty("testerAt03.password"));
            dashBoard = initSignIn.clickLoginButton();
        }
        return  dashBoard;

    }

}
