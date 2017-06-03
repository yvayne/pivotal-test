package org.fundacionjala.pivotal.help;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by Administrator on 6/2/2017.
 */
public final class Navegator {
    /**
     * constructor.
     */
    private Navegator() {
    }

    /**
     * nav.
     *
     * @param element webelemrn.
     */
    public static void goToDashBoard(final WebElement element) {
        DriverManager.getInstance().getWait()
                .until(ExpectedConditions.visibilityOf(element));
        DriverManager.getInstance().getDriver()
                .get("https://www.pivotaltracker.com/dashboard");
    }
}
