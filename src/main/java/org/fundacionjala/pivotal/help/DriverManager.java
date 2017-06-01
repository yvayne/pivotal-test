package org.fundacionjala.pivotal.help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 5/29/2017.
 */
public class DriverManager {

    private static DriverManager instance;

    private WebDriver driver;

    private WebDriverWait wait;
    String url = "https://www.pivotaltracker.com";
    private DriverManager() {
        driver = BrowserFactory.startBrowser("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);

        wait = new WebDriverWait(driver, 30);
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void setUrl(String url) {
        System.out.println("//////////>"+url);
        this.url=url;
    }
}
