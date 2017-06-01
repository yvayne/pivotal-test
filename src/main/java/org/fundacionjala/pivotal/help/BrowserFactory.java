package org.fundacionjala.pivotal.help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by reinaldo on 24/05/2017.
 */
public class BrowserFactory {

  public static WebDriver startBrowser(String browserName) {
    WebDriver driver;
    if (browserName.equals("firefox")) {
      driver = new FirefoxDriver();
    } else {
      driver = new ChromeDriver();
    }
    return driver;
  }
}

