package org.fundacionjala.pivotal.ui;

import org.fundacionjala.pivotal.help.LoadProperties;
import org.fundacionjala.pivotal.pages.DashBoard;
import org.fundacionjala.pivotal.pages.HomePage;
import org.fundacionjala.pivotal.pages.LoginIntellige;
import org.fundacionjala.pivotal.pages.SignIn;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by reinaldo on 26/05/2017.
 */
public class ProjectTest {
    HomePage initHomePage;
    SignIn initSignIn;
    DashBoard initDastBoard;

    @BeforeClass
    public void beforeClass() {
        initHomePage = new HomePage();
        initSignIn = initHomePage.clickSignInLink();
        initSignIn.setUserNameTextField(LoadProperties.user.getProperty("testerAt03.username"));
        initSignIn.clickNextButton();
        initSignIn.setPasswordTextField(LoadProperties.user.getProperty("testerAt03.password"));
        initDastBoard = initSignIn.clickLoginButton();
    }

    @Test
    public void writeProjectName() {
        initDastBoard.clickOnCreateProyectButton();
        initDastBoard.writeProjectName("Demore2");
        initDastBoard.clickOnSelectAnAccountCombo();
        initDastBoard.selectAnAccount("Fundacion Jala");
        initDastBoard.clickOnCreateAccountButton();
        //Assertion
    }

    @Test
    public void updateProjectName() {
        //Assertion
    }

    @Test
    public void deleteProjectName() {
        //Assertion
    }

}
