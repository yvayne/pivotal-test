package org.fundacionjala.pivotal.pages;

import org.fundacionjala.pivotal.help.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Administrator on 5/25/2017.
 */
public class DashBoard extends AbstractBasePage {
    @FindBy(id = "ProjectsPaneUpdated OpenCreateProjectModal-button")
    @CacheLookup
    WebElement createProyectButton;

    @FindBy(css = ".tc-form__input")
    @CacheLookup
    WebElement nameProyect;



    @FindBy(css = ".tc-account-selector__header")
    @CacheLookup
    WebElement selectAccountCombo;

    @FindBy(css = ".tc-account-selector__option-account")
    @CacheLookup
    WebElement accouts;


    @FindBy(css = ".tc-form-modal-footer__button.tc-form-modal-footer__button--submit")
    @CacheLookup
    WebElement createButton;

    @FindBy(className = "tc-account-selector__option-list")
    @CacheLookup
    WebElement accuntsContainer;

    @FindBy(css=".tc-form-modal-footer__button.tc-form-modal-footer__button--cancel")
    @CacheLookup
    WebElement cancelButton;

    @FindBy(css = ".tc-account-selector__option-account-name")
    @CacheLookup
    List<WebElement> accountsList;


    public void clickOnCreateProyectButton() {
        createProyectButton.click();

    }

    public void writeProjectName(String name) {
        CommonActions.setTextField(nameProyect,name);
    }

    public void clickOnSelectAnAccountCombo() {

        CommonActions.clickElement(selectAccountCombo);
    }
    public void selectAnAccount(String selectItem) {
       CommonActions.selectAnElement(accountsList,selectItem);
    }


    public void clickOnCreateAccountButton() {
        CommonActions.clickElement(createButton);
    }
}
