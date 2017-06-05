package org.fundacionjala.pivotal.pages;


import org.fundacionjala.pivotal.help.CommonActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by PABLO on 5/31/2017.
 */
public class Story extends AbstractBasePage {
    @FindBy(css = "div.sidebar_wrapper section ul li.item a.button.add_story")
    @CacheLookup
    private WebElement addStoryButton;

    @FindBy(css = ".Description___3oUx83yQ div.DescriptionShow___3-QsNMNj.tracker_markup")
    @CacheLookup
    private WebElement deployDescriptionButton;

    @FindBy(css = "._3nUTa__Button.y7fdk__Button--primary._3bRzW__Button--small")
    @CacheLookup
    private WebElement addDescriptionButton;

    @FindBy(css = ".selector.undraggable")
    @CacheLookup
    private WebElement selectStoryButton;

    @FindBy(css = "div.selectedStoriesControls div.selectedStoriesControls__actions button"
            + ".selectedStoriesControls__button.selectedStoriesControls__button--delete.delete")
    @CacheLookup
    private WebElement deleteStoryButton;

    @FindBy(css = "._3nUTa__Button._3Xv6T__Button--warning")
    @CacheLookup
    private WebElement confirmDeleteStoryButton;

    @FindBy(css = "div.type.row div.dropdown.story_type")
    @CacheLookup
    private WebElement deployStoryTypeButton;

    @FindBy(css = "div.estimate.row div.dropdown.story_estimate")
    @CacheLookup
    private WebElement deployPointsButton;

    @FindBy(css = "div.requester.row div.dropdown.story_requested_by_id a span div.name")
    @CacheLookup
    private WebElement deployRequestButton;

    @FindBy(css = "div.owner.row div.story_owners a")
    @CacheLookup
    private WebElement deployOwnerstButton;

    @FindBy(css = "button.autosaves.button.std.save")
    @CacheLookup
    private WebElement saveStoryButton;

    @FindBy(css = "section.blockers.full div div div span.AddSubresourceButton__message___2vsNCBXi")
    @CacheLookup
    private WebElement deployBlockersButton;

    @FindBy(css = "button.autosaves.button.std.close")
    @CacheLookup
    private WebElement autoUpdateAndCloseButton;

    @FindBy(css = "textarea.editor.tracker_markup.std.name")
    @CacheLookup
    private WebElement storyTitleTextField;

    @FindBy(css = ".AutosizeTextarea__textarea___1LL2IPEy.editor___1qKjhI5c.tracker_markup")
    @CacheLookup
    private WebElement clickDescriptionTextField;

    @FindBy(css = "div.type.row div.dropdown_menu.search div.search_item input")
    @CacheLookup
    private WebElement storyTypeTextField;

    @FindBy(css = "div.estimate.row div.dropdown.story_estimate section div.dropdown_menu div.search_item input")
    @CacheLookup
    private WebElement pointsTextField;

    @FindBy(css = ".tn-text-input__field___3gLo07Il.tn-text-input__field-"
            + "-medium___v3Ex3B7Z.LabelsSearch__input___2CXcYAak")
    @CacheLookup
    private WebElement labelTextField;

    @FindBy(css = "div.BlockerEdit___3ty1LeoB div.BlockerEdit__descriptionContainer___286CqEHp div div textarea")
    @CacheLookup
    private WebElement blockersTextField;

    @FindBy(css = "div.requester.row div.dropdown.story_requested_by_id section div.dropdown_menu.search div input")
    @CacheLookup
    private WebElement requestTextField;

    @FindBy(id = "owners_search_field")
    @CacheLookup
    private WebElement ownersTextField;

    @FindBy(css = ".expander.undraggable")
    @CacheLookup
    private WebElement deployStoryButton;

    @FindBy(css = ".dropdown.story_type")
    @CacheLookup
    private WebElement storyTypeNameLabel;

    /**
     * Click on Add Story.
     */

    public void setClickAddStory() {
        addStoryButton.click();
    }

    /**
     * Write on text field Story Title.
     * @param storyTitle is the story name.
     */

    public void writeStoryTitle(final String storyTitle) {
        storyTitleTextField.sendKeys(storyTitle);
    }

    /**
     * Click for deploy Story Type.
     */

    public void clickDeployStoryType() {
        CommonActions.clickElement(deployStoryTypeButton);
    }

    /**
     * Click to select Story Type.
     * @param storyType is the story type name to select.
     * @param pointsName is the points name to select.
     */

    public void clickWriteSelectStoryType(final String storyType, final String pointsName) {
        storyTypeTextField.sendKeys(storyType, Keys.ENTER);
        if (storyType.contains("Feature")) {
            if (storyTypeNameLabel.getText().toString().equalsIgnoreCase(storyType)) {
                CommonActions.clickElement(deployPointsButton);
                pointsTextField.sendKeys(pointsName, Keys.ENTER);
            }
        }
    }

    /**
     * Click for deploy request.
     */

    public void clickDeployRequester() {
        deployRequestButton.click();
        //CommonActions.clickElement(deployRequestButton);
    }

    /**
     * Click on text field to requester.
     * @param requestName is the requester to story.
     */

    public void clickWriteSelectRequester(final String requestName) {
        requestTextField.sendKeys(requestName, Keys.ENTER);
    }

    /**
     * Click deploy owners.
     */

    public void clickDeployOwners() {
        CommonActions.clickElement(deployOwnerstButton);
    }

    /**
     * Click on text field owners.
     * @param ownersName is the owners name of the story.
     */

    public void clickWriteSelectOwners(final String ownersName) {
        ownersTextField.sendKeys(ownersName, Keys.ENTER);
    }

    /**
     * Click for deploy blockers.
     */

    public void clickDeployBlockers() {
        deployBlockersButton.click();
    }

    /**
     * Write on text field to blockers.
     * @param blockersText is the blockers text of the story.
     */

    public void clickWriteBlockers(final String[] blockersText) {
        for (String blockers : blockersText) {
            this.blockersTextField.sendKeys(blockers, Keys.ENTER);
        }
    }

    /**
     * Write and add description.
     * @param addDescription is the descroption of the story.
     */

    public void writeAddDescription(final String addDescription) {
        clickDescriptionTextField.sendKeys(addDescription);
    }

    /**
     * Click for deploy description.
     */

    public void clickDeployDescription() {
        deployDescriptionButton.click();
    }

    /**
     * Click on description.
     */

    public void clickAddDescription() {
        addDescriptionButton.click();
    }

    /**
     * Write and add label.
     * @param labelTextField is the label text of the project.
     */

    public void writeAddLabel(final String[] labelTextField) {
        for (String label : labelTextField) {
            this.labelTextField.sendKeys(label, Keys.ENTER);
        }
    }

    /**
     * Click on Save button.
     */

    public void clickSaveStory() {
        saveStoryButton.click();
    }

    /**
     * Click selector story.
     */

    public void clickSelectStory() {
        selectStoryButton.click();
    }

    /**
     * Delete story.
     */

    public void clickDeleteStory() {
        deleteStoryButton.click();
    }

    /**
     * Confirm delete story.
     */

    public void clickConfirmDeleteStory() {
        confirmDeleteStoryButton.click();
    }

    /**
     * Click on the element.
     * @return the instance of the StoryUpdate class.
     */

    public StoryUpdate updateStory() {
        CommonActions.clickElement(deployStoryButton);
        return new StoryUpdate();
    }
}
