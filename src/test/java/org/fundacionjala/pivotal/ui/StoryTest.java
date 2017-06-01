package org.fundacionjala.pivotal.ui;

import org.fundacionjala.pivotal.pages.DashBoard;
import org.fundacionjala.pivotal.pages.HomePage;
import org.fundacionjala.pivotal.pages.LoginIntellige;
import org.fundacionjala.pivotal.pages.SignIn;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by reinaldo on 26/05/2017.
 */
public class StoryTest {
  //HomePage initHomePage;
  //SignIn initSignIn;
  DashBoard initDastBoard;
  LoginIntellige loginIntellige;
  @BeforeClass
  public void beforeClass() {
    loginIntellige =new LoginIntellige();
    initDastBoard = loginIntellige.verifyTheLoginOfUser();
   /* initHomePage = new HomePage();
    initSignIn = initHomePage.clickSignInLink();
    initSignIn.setUserNameTextField("juan.aitken@fundacion-jala.org");
    initSignIn.clickNextButton();
    initSignIn.setPasswordTextField("test123456");
    initDastBoard = initSignIn.clickLoginButton();*/
  }

  @Test
  public void writeProjectName() {
   /* initDastBoard.clickOnCreateProyectButton();
    initDastBoard.writeProjectName("Demo5");
    initDastBoard.clickOnSelectAnAccountCombo();
    initDastBoard.selectAnAccount("Fundacion Jala");
    initDastBoard.clickOnCreateAccountButton();*/
    //Assertion
  }

}
