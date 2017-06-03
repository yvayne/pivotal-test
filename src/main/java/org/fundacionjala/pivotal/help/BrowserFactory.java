package org.fundacionjala.pivotal.help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by reinaldo on 24/05/2017.
 */
public final class BrowserFactory {

    /**
     * constructor.
     */
    private BrowserFactory() {

    }

    /**
     * webDriver function.
     * @param browserName kind of browser.
     * @return the driver
     */

    public static WebDriver startBrowser(final String browserName) {
        WebDriver driver;
        if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
        return driver;
    }
}

