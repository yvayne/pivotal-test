package org.fundacionjala.pivotal.help;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by Juan on 6/2/2017.
 */
public final class Navegator {

    /**
     * constructor.
     */
    private Navegator() {

    }

    /**
     * This method go to the dash board page.
     *
     * @param element is a webElement.
     */
    public static void goToDashBoard(final WebElement element) {
        DriverManager.getInstance().getWait()
                .until(ExpectedConditions.visibilityOf(element));
//    DashBoard dashBoard = new DashBoard();
//    dashBoard.getWebDriver().get("https://www.pivotaltracker.com/dashboard");
        DriverManager.getInstance().getDriver()
                .get("https://www.pivotaltracker.com/dashboard");
    }
}
