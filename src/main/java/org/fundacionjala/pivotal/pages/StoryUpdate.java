package org.fundacionjala.pivotal.pages;

import org.fundacionjala.pivotal.help.CommonActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by PABLO on 6/4/2017.
 */
public class StoryUpdate extends AbstractBasePage {

    @FindBy(css = ".Description___3oUx83yQ div.DescriptionShow___3-QsNMNj.tracker_markup")
    @CacheLookup
    private WebElement deployUpdateDescriptionButton;

    @FindBy(css = "._3nUTa__Button.y7fdk__Button--primary._3bRzW__Button--small")
    @CacheLookup
    private WebElement addUpdateDescriptionButton;

    @FindBy(css = "div.type.row div.dropdown.story_type")
    @CacheLookup
    private WebElement deployUpdateStoryTypeButton;

    @FindBy(css = "div.estimate.row div.dropdown.story_estimate")
    @CacheLookup
    private WebElement deployUpdatePointsButton;

    @FindBy(css = "div.requester.row div.dropdown.story_requested_by_id a span div.name")
    @CacheLookup
    private WebElement deployUpdateRequestButton;

    @FindBy(css = "div.owner.row div.story_owners a")
    @CacheLookup
    private WebElement deployUpdateOwnerstButton;

    @FindBy(css = "section.blockers.full div div div span.AddSubresourceButton__message___2vsNCBXi")
    @CacheLookup
    private WebElement deployUpdateBlockersButton;

    @FindBy(css = "button.autosaves.button.std.close")
    @CacheLookup
    private WebElement autoUpdateAndCloseButton;

    @FindBy(css = "textarea.editor.tracker_markup.std.name")
    @CacheLookup
    private WebElement storyUpdateTitleTextField;

    @FindBy(css = ".AutosizeTextarea__textarea___1LL2IPEy.editor___1qKjhI5c.tracker_markup")
    @CacheLookup
    private WebElement clickUpdateDescriptionTextField;

    @FindBy(css = "div.type.row div.dropdown_menu.search div.search_item input")
    @CacheLookup
    private WebElement storyUpdateTypeTextField;

    @FindBy(css = "div.estimate.row div.dropdown.story_estimate section div.dropdown_menu div.search_item input")
    @CacheLookup
    private WebElement pointsUpdateTextField;

    @FindBy(css = ".tn-text-input__field___3gLo07Il.tn-text-input__field-"
            + "-medium___v3Ex3B7Z.LabelsSearch__input___2CXcYAak")
    @CacheLookup
    private WebElement labelTextField;

    @FindBy(css = "div.BlockerEdit___3ty1LeoB div.BlockerEdit__descriptionContainer___286CqEHp div div textarea")
    @CacheLookup
    private WebElement blockersUpdateTextField;

    @FindBy(css = "div.requester.row div.dropdown.story_requested_by_id section div.dropdown_menu.search div input")
    @CacheLookup
    private WebElement requestUpdateTextField;

    @FindBy(id = "owners_search_field")
    @CacheLookup
    private WebElement ownersUpdateTextField;

    @FindBy(css = ".dropdown.story_type")
    @CacheLookup
    private WebElement storyUpdateTypeNameLabel;

    /**
     * Update story title.
     * @param updateStoryTitle story title to update.
     */

    public void writeUpdateStoryTitle(final String updateStoryTitle) {
        CommonActions.setTextField(storyUpdateTitleTextField, updateStoryTitle);
    }

    /**
     * Deploy story type for update.
     */

    public void clickUpdateDeployStoryType() {
        CommonActions.clickElement(deployUpdateStoryTypeButton);
    }

    /**
     * Write Story type.
     * @param storyType story type to select for update.
     * @param pointsName points to select for update.
     */

    public void clickUpdateWriteSelectStoryType(final String storyType, final String pointsName) {
        storyUpdateTypeTextField.sendKeys(storyType, Keys.ENTER);
        if (storyType.contains("Feature")) {
            if (storyUpdateTypeNameLabel.getText().toString().equalsIgnoreCase(storyType)) {
                CommonActions.clickElement(deployUpdatePointsButton);
                pointsUpdateTextField.sendKeys(pointsName, Keys.ENTER);
            }
        }
    }

    /**
     * Deploy requester from update.
     */

    public void clickUpdateDeployRequester() {
        deployUpdateRequestButton.click();
    }

    /**
     * Update requester selected.
     * @param requestName requester name to selected.
     */

    public void clickUpdateWriteSelectRequester(final String requestName) {
        requestUpdateTextField.sendKeys(requestName, Keys.ENTER);
    }

    /**
     * Deploy owners to update.
     */

    public void clickUpdateDeployOwners() {
        CommonActions.clickElement(deployUpdateOwnerstButton);
    }

    /**
     * Select owners to update.
     * @param ownersName owners name to update.
     */

    public void clickUpdateWriteSelectOwners(final String ownersName) {
        ownersUpdateTextField.sendKeys(ownersName, Keys.ENTER);
    }

    /**
     * Deploy blockers.
     */

    public void clickUpdateDeployBlockers() {
        deployUpdateBlockersButton.click();
    }

    /**
     * Update blockers.
     * @param blockersText blockers text to update.
     */

    public void clickUpdateWriteBlockers(final String[] blockersText) {
        for (String blockers : blockersText) {
            this.blockersUpdateTextField.sendKeys(blockers, Keys.ENTER);
        }
    }

    /**
     * Deploy description to update.
     */

    public void clickUpdateDeployDescription() {
        deployUpdateDescriptionButton.click();
    }

    /**
     * Click on description.
     */

    public void clickUpdateAddDescription() {
        addUpdateDescriptionButton.click();
    }

    /**
     * Write and aadd label.
     * @param labelTextField label text to update.
     */

    public void writeUpdateAddLabel(final String[] labelTextField) {
        for (String label : labelTextField) {
            this.labelTextField.sendKeys(label, Keys.ENTER);
        }
    }

    /**
     * Update description.
     * @param addDescription description to update.
     */

    public void writeUpdateAddDescription(final String addDescription) {
        clickUpdateDescriptionTextField.sendKeys(addDescription);
    }

    /**
     * Update and close to update.
     */

    public void clickAutoUpdateAndClose() {
        autoUpdateAndCloseButton.click();
    }
}
