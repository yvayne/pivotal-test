package org.fundacionjala.pivotal.pages;

import org.fundacionjala.pivotal.help.CommonActions;
import org.fundacionjala.pivotal.help.Navegator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 6/1/2017.
 */
public class ProjectSettings extends AbstractBasePage {
  /**
   * Locate delete link.
   */
  @FindBy(id = "delete_link")
  @CacheLookup
  private WebElement deleteLink;

  /**
   * Locate confirm delete button.
   */
  @FindBy(id = "confirm_delete")
  @CacheLookup
  private WebElement confirmDeleteButton;

  /**
   * Locate delete dialog.
   */
  @FindBy(css = ".delete.inline_dialog")
  @CacheLookup
  private WebElement deleteDialog;

  /**
   * Locate delete link.
   */
  @FindBy(id = "project_name")
  @CacheLookup
  private WebElement updateProjectNameField;

  /**
   * Locate projectDescriptionField.
   */
  @FindBy(id = "project_description")
  @CacheLookup
  private WebElement projectDescription;

  /**
   * Locate saveProject button.
   */
  @FindBy(css = ".save_bar__submit")
  @CacheLookup
  private WebElement saveProject;

  /**
   * Locate enableTaskCheckbox.
   */
  @FindBy(id = "project_enable_tasks")
  @CacheLookup
  private WebElement enableTaskCheckBox;

  /**
   * Locate publicCheckbox.
   */
  @FindBy(id = "project_public")
  @CacheLookup
  private WebElement publicCheckBox;

  /**
   * Locate apiCheckbox.
   */
  @FindBy(id = "project_api_access")
  @CacheLookup
  private WebElement aPiAccessCheckBox;

  /**
   * Locate enableRSSCheckbox.
   */
  @FindBy(id = "project_api_access")
  @CacheLookup
  private WebElement enableRSSatomCheckBox;

  /**
   * Locate hideEmailCheckbox.
   */
  @FindBy(id = "project_hide_emails_from_collaborators")
  @CacheLookup
  private WebElement hideEmailCheckBox;

  /**
   * Locate givenPoinstCheckbox.
   */
  @FindBy(id = "project_bugs_and_chores_are_estimatable")
  @CacheLookup
  private WebElement givenPointsCheckBox;

  /**Instance of Navegator class.
   */


  /**click on delete link.
   */
  public void clickOnDeleteLink() {
    CommonActions.clickOnaHiddenElement(deleteLink);
  }

  /**click on comfirm delete button.
   */
  public void clickOnConfirmDeleteButton() {
    CommonActions.clickElement(confirmDeleteButton);
  }

  /**update projectName field.
   * @param newProjectName is the new name
   */
  public void updateProjectName(final String newProjectName) {
    CommonActions.setTextField(updateProjectNameField, newProjectName);
  }

  /**click save project button.
   */
  public void clickOnSaveProjectButton() {
    CommonActions.clickElement(saveProject);
  }

  /**verify message project deletion.
   * @return true if the message is correct or false if not.
   */
  public boolean verifyDeleteDialogMessage() {
    String expectedMessage = "You are about to delete this project.";
    return CommonActions.verifyMessages(deleteDialog, expectedMessage);
  }

  /**verify if the delete button is enable.
   * @return true if is enable or false if is not.
   */

  public boolean verifyIfTheConfirmDeleteButtonIsEnable() {
    return confirmDeleteButton.isEnabled();
  }

  /**Set Project description.
   * @param  description project description.
   */

  public void setProjectDescription(final String description) {
    CommonActions.setTextField(projectDescription, description);
  }

  /**check checkbox.
   */

  public void checkEnableTaskCheckBox() {
    CommonActions.clickElement(enableTaskCheckBox);
  }

  /**check checkbox.
   */
  public void checkPublicCheckBox() {
    CommonActions.clickElement(publicCheckBox);
  }

  /**check checkbox.
   */
  public void checkApiAccessCheckBox() {
    CommonActions.clickOnaHiddenElement(aPiAccessCheckBox);
  }

  /**check checkbox.
   */
  public void checkEnableRSSatomCheckBox() {
    CommonActions.clickOnaHiddenElement(enableRSSatomCheckBox);
  }

  /**check checkbox.
   */
  public void checkHideEmailCheckBox() {
    CommonActions.clickOnaHiddenElement(hideEmailCheckBox);
  }

  /**check checkbox.
   */
  public void givenPointsCheckBox() {
    CommonActions.clickOnaHiddenElement(givenPointsCheckBox);
  }

  /**Go to the DashBoard page.
   */
  public void goToDashBoard() {
    Navegator.goToDashBoard(givenPointsCheckBox);
  }


}
