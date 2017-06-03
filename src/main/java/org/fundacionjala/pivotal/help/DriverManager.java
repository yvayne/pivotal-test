package org.fundacionjala.pivotal.help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 5/29/2017.
 */
public final class DriverManager {
    /**
     * instance.
     */
    private static DriverManager instance;
    /**
     * driver.
     */
    private WebDriver driver;
    /**
     * wait.
     */
    private WebDriverWait wait;
    /**
     * url pivotal tracker.
     */
    private String url = "https://www.pivotaltracker.com";

    /**
     * Cotructor.
     */
    private DriverManager() {
        final int timeOut = 30;
        driver = BrowserFactory.startBrowser("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        driver.get(url);

        wait = new WebDriverWait(driver, timeOut);
    }
    /**
     * getInstance.
     * @return the instance
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }
    /**
     * getDriver.
     * @return driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * getwait.
     * @return the wait.
     */
    public WebDriverWait getWait() {
        return wait;
    }


}
