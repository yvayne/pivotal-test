package org.fundacionjala.pivotal.pages;

import org.fundacionjala.pivotal.help.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 5/26/2017.
 */
public abstract class AbstractBasePage {

    protected WebDriver webDriver;

    protected WebDriverWait wait;


    /**
     * HomePage constructor
     */
    public AbstractBasePage() {
        String url = "https://www.pivotaltracker.com";
        webDriver = DriverManager.getInstance().getDriver();
        // this.webDriver = BrowserFactory.startBrowser("firefox", "https://www.pivotaltracker.com");
        PageFactory.initElements(webDriver, this);

        wait = DriverManager.getInstance().getWait();
    }

}
