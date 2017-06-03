package org.fundacionjala.pivotal.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 5/25/2017.
 */
public class HomePage extends AbstractBasePage {

    /**
     * locator.
     */
    @FindBy(css = "a[href='/signin'][class='header__link']")
    @CacheLookup
    private WebElement signInLink;

    /**
     * InitSignIn click_signing_link event.
     * @return a new sigin
     */
    public SignIn clickSignInLink() {
        signInLink.click();
        return new SignIn();
    }

}
