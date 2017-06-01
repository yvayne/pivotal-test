package org.fundacionjala.pivotal.help;

import org.openqa.selenium.Beta;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Administrator on 5/30/2017.
 */
public class CommonActions {

    public static void setTextField(WebElement element, String text) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public static void clickElement(WebElement element) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void selectAnElement(List<WebElement> elementsList, String selectItem) {
        new WebDriverWait(DriverManager.getInstance().getDriver(),30);
        for (WebElement accountWebElement1 : elementsList) {
            if (accountWebElement1.getText().equals(selectItem)) {
                accountWebElement1.click();
                break;
            }
        }
    }
}
