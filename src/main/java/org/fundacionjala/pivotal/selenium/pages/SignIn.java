package org.fundacionjala.pivotal.selenium.pages;

import org.fundacionjala.pivotal.help.CommonActions;
import org.fundacionjala.pivotal.help.DriverManager;
import org.fundacionjala.pivotal.help.Navegator;
import org.fundacionjala.pivotal.utils.Environment;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by Administrator on 5/25/2017.
 */
public class SignIn extends AbstractBasePage {
    /**
     * Locate element.
     */
    @FindBy(id = "ProjectsPaneUpdated OpenCreateProjectModal-button")
    @CacheLookup
    private WebElement createProyectButton;

    /**
     * Locate element.
     */
    @FindBy(id = "credentials_username")
    @CacheLookup
    private WebElement usernameTextField;

    /**
     * Locate element.
     */
    @FindBy(css = ".app_signin_action_button")
    @CacheLookup
    private WebElement nextButton;

    /**
     * Locate element.
     */
    @FindBy(id = "credentials_password")
    @CacheLookup
    private WebElement passwordTextField;

    /**
     * Locate element.
     */
    @FindBy(css = ".app_signin_action_button")
    @CacheLookup
    private WebElement loginButton;

    /**
     * Locate element.
     */
    @FindBy(css = ".app_signin_back")
    @CacheLookup
    private WebElement signDifferentUser;

    /**
     * Locate element.
     */
    @FindBy(css = ".tc_dropdown_name")

    private WebElement userInLink;
    /**
     * Locate element.
     */
    @FindBy(css = "._1JRsk__DropdownMenu__menuList>li>form>button")

    private WebElement singOutButton;
    /**
     * Locate element.
     */
    @FindBy(css = ".tc_header_item.tc_header_logo")
    @CacheLookup
    private WebElement toggleBar;

    /**
     * Locate element.
     */
    private static DashBoard dashBoard;

    /**
     * setUserName.
     *
     * @param mail is the mail.
     */
    public void setUserNameTextField(final String mail) {
        CommonActions.setTextField(usernameTextField, mail);
    }

    /**
     * setUserName.
     *
     * @param password is the password.
     */
    public void setPasswordTextField(final String password) {
        CommonActions.setTextField(passwordTextField, password);
    }

    /**
     * click.
     */
    public void clickNextButton() {
        CommonActions.clickElement(nextButton);
    }

    /**
     * click.
     *
     * @return a new dashboard.
     */
    public DashBoard clickLoginButton() {
        CommonActions.clickElement(loginButton);
        return new DashBoard();
    }

    /**
     * click.
     */
    public void clickSelectItem() {
        CommonActions.clickOnaHiddenElement(userInLink);
    }

    /**
     * click.
     */
    public void clickSingOutButton() {
        CommonActions.clickElement(singOutButton);
    }

    /**
     * click.
     */
    public void clickDifferentUser() {
        CommonActions.clickElement(signDifferentUser);
    }

    /**
     * This verifyTheLoginOfUser method verify if user is login  or don't login.
     *
     * @param username is the username
     * @param password is the password
     */
    public static void verifyTheLoginOfUser(final String username,
                                            final String password) {
        SignIn signIn = new SignIn();
        try {
            if (signIn.userInLink.getText() != null && !signIn.userInLink.
                    getText().equalsIgnoreCase(username)) {

                System.out.print("entro-->");
                Navegator.goToDashBoard(signIn.toggleBar);
                signIn.getWebDriver().navigate()
                        .to("https://www.pivotaltracker.com/dashboard");


                DriverManager.getInstance().getWait()
                        .until(ExpectedConditions.
                                visibilityOf(signIn.createProyectButton));
                signIn.clickSelectItem();
                signIn.clickSingOutButton();
                signIn.clickDifferentUser();
                signIn.setUserNameTextField(username);
                signIn.clickNextButton();
                signIn.setPasswordTextField(password);
                dashBoard = signIn.clickLoginButton();
            }
            //signin con nueva cuenta (username, password)


        } catch (WebDriverException webDriveException) {
            /**
             * forzar ir al signup page
             */
            signIn.getWebDriver().navigate().to(Environment.getInstance()
                    .getPropertyValue("testerAt03.singIn"));
            signIn.setUserNameTextField(Environment.getInstance()
                    .getPropertyValue("testerAt03.username"));
            signIn.clickNextButton();
            signIn.setPasswordTextField(Environment.getInstance()
                    .getPropertyValue("testerAt03.password"));
            dashBoard = signIn.clickLoginButton();
        }
    }

}

