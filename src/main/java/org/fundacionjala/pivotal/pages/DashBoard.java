package org.fundacionjala.pivotal.pages;

import org.fundacionjala.pivotal.help.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Juan on 5/25/2017.
 */
public class DashBoard extends AbstractBasePage {
  /**
   * Locate webElement.
   */
  @FindBy(id = "ProjectsPaneUpdated OpenCreateProjectModal-button")
  @CacheLookup
  private WebElement createProyectButton;

  /**
   * Locate webElement.
   */
  @FindBy(css = ".tc-form__input")
  @CacheLookup
  private WebElement nameProyect;

  /**
   * Locate webElement.
   */
  @FindBy(css = ".tc-account-selector__header")
  @CacheLookup
  private WebElement selectAccountCombo;

  /**
   * Locate webElement.
   */
  @FindBy(css = ".tc-form-modal-footer__button."
          + "tc-form-modal-footer__button--submit")
  @CacheLookup
  private WebElement createButton;
  /**
   * Locate webElement.
   */
  @FindBy(css = ".tc-account-selector__option-account-name")
  @CacheLookup
  private List<WebElement> accountsList;

  /**
   * Locate webElement.
   */
  @FindBy(css = "#projects-search-bar")
  private WebElement projectSearchBar;

  /**
   * Locate webElement.
   */
  @FindBy(css = ".projectTileHeader__projectName."
          + "projectTileHeader__projectName--active")
  @CacheLookup
  private List<WebElement> projectHeader;

  /**
   * Locate webElement.
   */
  @FindBy(css = ".SettingsIcon__cog.projectTileHeader__hoverable")
  private WebElement proyectSettingButton;

  /**
   * Locate webElement.
   */
  @FindBy(css = "#notice")
  @CacheLookup
  private WebElement projectDeletionMessage;

  /**
   * Locate webElement.
   */
  @FindBy(css = "a.projectTileHeader__projectName.projectTileHeader__projectName--active")
  @CacheLookup
  private WebElement selectProject;


  /**
   * Click on the Element.
   */
  public void clickOnCreateProyectButton() {
    createProyectButton.click();
  }

  /**
   * Click on the Element.
   *
   * @param name is the name of the project.
   */
  public void writeProjectName(final String name) {
    CommonActions.setTextField(nameProyect, name);
  }

  /**
   * Click on the Element.
   */
  public void clickOnSelectAnAccountCombo() {
    CommonActions.clickElement(selectAccountCombo);
  }

  /**
   * Click on the Element.
   *
   * @param selectItem is the item to be elected.
   */
  public void selectAnAccount(final String selectItem) {
    WebElement element = CommonActions.
            selectAnElement(accountsList, selectItem);
    element.click();
  }

  /**
   * Click on the Element.
   *
   * @param projectName is the name of the project to the searched.
   */
  public void searchForAProject(final String projectName) {
    CommonActions.setTextField(projectSearchBar, projectName);
  }

  /**
   * Message verification.
   *
   * @return true or false to determine if the message is correct.
   */
  public boolean verifyDeletionMessage() {
    return CommonActions.verifyMessages(projectDeletionMessage,
            "was successfully deleted.");
  }

  /**
   * Verify if the serach box is present.
   *
   * @return true or false.
   */
  public boolean verifyIfTheSearchBoxIsPresent() {
    return CommonActions.assertAndVerifyElement(projectSearchBar);
  }

  /**
   * Click on element.
   * @return is the name of the project to the searched.
   */
  public Story clickSelectProject() {
    CommonActions.clickElement(selectProject);
    return new Story();
  }

}

