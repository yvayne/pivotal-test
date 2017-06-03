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
     * construcotor.
     */
    private CommonActions() {
    }

    /**
     * setText.
     *
     * @param element webemet.
     * @param text    text to set
     */
    public static void setTextField(final WebElement element,
                                    final String text) {
        DriverManager.getInstance().getWait()
                .until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Click.
     *
     * @param element element
     */
    public static void clickElement(final WebElement element) {
        DriverManager.getInstance().getWait()
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * Click.
     *
     * @param elementsList list of elemetns.
     * @param selectItem imtm.
     */
    public static void selectAnElement(final List<WebElement> elementsList,
                                       final String selectItem) {
        final int timeOut = 30;
        new WebDriverWait(DriverManager.getInstance().getDriver(), timeOut);
        for (WebElement accountWebElement1 : elementsList) {
            if (accountWebElement1.getText().equals(selectItem)) {
                accountWebElement1.click();
                break;
            }
        }
    }

    /**
     * Click.
     *
     * @param element to seelt
     */
    public static void clickOnaHiddenElement(final WebElement element) {
        DriverManager.getInstance().getWait()
                .until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor executor =
                (JavascriptExecutor) DriverManager.getInstance().getDriver();
        executor.executeScript("arguments[0].click()", element);
    }
}
