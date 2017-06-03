package org.fundacionjala.pivotal.pages;


import org.fundacionjala.pivotal.help.Navegator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Administrator on 5/25/2017.
 */
public class Projects extends AbstractBasePage {

  /**Locate stories label.
   */
  @FindBy(css = "._1iDu8__projectNavTab._1JNTs__projectNavTab--current>span")
  @CacheLookup
  private WebElement storiesLabel;

  /**Go to DashBoard Page.
   */
  public void goToDashBoard() {
    Navegator.goToDashBoard(storiesLabel);
  }
}
