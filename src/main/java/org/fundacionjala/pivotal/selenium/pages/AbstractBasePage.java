package org.fundacionjala.pivotal.selenium.pages;

import org.fundacionjala.pivotal.help.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Administrator on 5/26/2017.
 */
public abstract class AbstractBasePage {

    private WebDriver webDriver;

    /**
     * HomePage constructor.
     */
    public AbstractBasePage() {
        this.setWebDriver(DriverManager.getInstance().getDriver());
        PageFactory.initElements(getWebDriver(), this);
    }

    /**
     * The method webdriver().
     * @return driver data.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * This is setWebDriver.
     * @param webDriver data
     */
    public void setWebDriver(final WebDriver webDriver) {
        this.webDriver = webDriver;
    }


}
