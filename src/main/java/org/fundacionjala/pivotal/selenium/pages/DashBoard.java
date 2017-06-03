package org.fundacionjala.pivotal.selenium.pages;

import org.fundacionjala.pivotal.help.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Administrator on 5/25/2017.
 */
public class DashBoard extends AbstractBasePage {
    /**
     * locator.
     */
    @FindBy(id = "ProjectsPaneUpdated OpenCreateProjectModal-button")
    @CacheLookup
    private WebElement createProyectButton;
    /**
     * locator.
     */
    @FindBy(css = ".tc-form__input")
    @CacheLookup
    private WebElement nameProyect;

    /**
     * locator.
     */
    @FindBy(css = ".tc-account-selector__header")
    @CacheLookup
    private WebElement selectAccountCombo;
    /**
     * locator.
     */
    @FindBy(css = ".tc-account-selector__option-account")
    @CacheLookup
    private WebElement accouts;

    /**
     * locator.
     */
    @FindBy(css = ".tc-form-modal-footer__button."
            + "tc-form-modal-footer__button--submit")
    @CacheLookup
    private WebElement createButton;
    /**
     * locator.
     */
    @FindBy(className = "tc-account-selector__option-list")
    @CacheLookup
    private WebElement accuntsContainer;
    /**
     * locator.
     */
    @FindBy(css = ".tc-form-modal-footer__button."
            + "tc-form-modal-footer__button--cancel")
    @CacheLookup
    private WebElement cancelButton;
    /**
     * locator.
     */
    @FindBy(css = ".tc-account-selector__option-account-name")
    @CacheLookup
    private List<WebElement> accountsList;

    /**
     * click.
     */
    public void clickOnCreateProyectButton() {
        createProyectButton.click();

    }

    /**
     * write project name.
     *
     * @param name project.
     */
    public void writeProjectName(final String name) {
        CommonActions.setTextField(nameProyect, name);
    }

    /**
     * locator.
     */
    public void clickOnSelectAnAccountCombo() {

        CommonActions.clickElement(selectAccountCombo);
    }

    /**
     * locator.
     *
     * @param selectItem to be selected.
     */
    public void selectAnAccount(final String selectItem) {
        CommonActions.selectAnElement(accountsList, selectItem);
    }

    /**
     * locator.
     */
    public void clickOnCreateAccountButton() {
        CommonActions.clickElement(createButton);
    }
}
