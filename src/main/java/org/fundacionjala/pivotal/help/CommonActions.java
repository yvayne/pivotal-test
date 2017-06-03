/**
 * CommonActions used on the webPages .....
 * <p>
 * These classes contain the methods that are used by the pageObjects.
 * </p>
 * @since 1.0
 * @author somebody
 * @version 1.0
 */
package org.fundacionjala.pivotal.help;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Created by Administrator on 5/30/2017.
 */
public final class CommonActions {


  /**
   * Constructor.
   */
  private CommonActions() {
  }

  /**
   * Set text in a text field.
   *
   * @param element is a WebElement
   * @param text    is the text to set
   */

  public static void setTextField(final WebElement element, final String text) {
    DriverManager.getInstance().getWait().
            until(ExpectedConditions.visibilityOf(element));
    element.clear();
    element.sendKeys(text);
  }

  /**
   * Click on a element.
   *
   * @param element is a WebElement
   */
  public static void clickElement(final WebElement element) {
    DriverManager.getInstance().getWait()
            .until(ExpectedConditions.elementToBeClickable(element));
    element.click();
  }

  /**
   * Select an list of elements.
   * @param elementsList is a WebElement
   * @param selectItem is the item looked for
   * @return element return a WebElement
   */
  public static WebElement selectAnElement(final List<WebElement> elementsList,
                                           final String selectItem) {
    final int timeOut = 30;
    WebElement element = null;
    new WebDriverWait(DriverManager.getInstance()
            .getDriver(), timeOut);
    for (WebElement accountWebElement1 : elementsList) {
      if (accountWebElement1.getText().equals(selectItem)) {
        element = accountWebElement1;
        break;
      }
    }
    return element;
  }

  /**
   * Click on a hidden element.
   * @param element is a webElement
   */
  public static void clickOnaHiddenElement(final WebElement element) {
    JavascriptExecutor executor =
            (JavascriptExecutor) DriverManager.getInstance().getDriver();
    executor.executeScript("arguments[0].click()", element);
  }

  /**
   * Verify Messges.
   *
   * @param element is a WebElement
   * @param message is the message that shows the application.
   * @return true  if the element is present or false if not
   */
  public static boolean verifyMessages(final WebElement element,
                                       final String message) {
    return element.getText().contains(message);
  }

  /**
   * Verify if a element is enabled.
   * @param element is a WebElement
   * @return true  if the element is present or false if not
   */
  public static boolean assertAndVerifyElement(final WebElement element) {
    return element.isEnabled();
  }
}
