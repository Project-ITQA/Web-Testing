package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import utils.TestUtils;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers")
public class UserManagementPage extends PageObject {

    @FindBy(xpath = "//button[normalize-space()='Add']")
    private WebElementFacade addUserButton;

    @FindBy(xpath = "//label[normalize-space()='Username']/following::input[1]")
    private WebElementFacade usernameField;

    @FindBy(css = "button[type=submit]")
    private WebElementFacade userSearchButton;

    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span[contains(@class, 'oxd-text')]")
    private WebElementFacade searchResultPhrase;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button--secondary') and text()=' Search ']")
    private WebElementFacade searchButton;

    @FindBy(xpath = "//button[contains(@class, 'oxd-icon-button') and i[contains(@class, 'bi-trash')]]")
    private WebElementFacade deleteButton;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button--label-danger') and text()=' Yes, Delete ']")
    private WebElementFacade confirmDeleteButton;

    public void clickAddUserButton() {
        addUserButton.click();
    }

    public void verifyCurrentPage() {
        String currentURL = (getDriver().getCurrentUrl());
        System.out.println(currentURL);
        assert currentURL != null;
        Assert.assertTrue(currentURL.contains("admin/viewSystemUsers"));
    }

    public void checkUsername(String username) {
        usernameField.type(username);
        userSearchButton.click();
        searchResultPhrase.waitUntilVisible();
        Assert.assertTrue(searchResultPhrase.containsText("(1)"));

    }

    public void checkUsernameNotAvailable(String username) {
        usernameField.type(username);
        userSearchButton.click();
        searchResultPhrase.waitUntilVisible();
        Assert.assertTrue(searchResultPhrase.containsText("No"));

    }

    public void typeIntoSearchBox(String text) {
        usernameField.waitUntilVisible();
        usernameField.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.waitUntilVisible();
        searchButton.click();
    }

    public void clickDeleteButton(String username) {
        usernameField.sendKeys(username);
        deleteButton.click();
    }

    public void clickConfirmDeleteButton() {
        TestUtils.addDelay(5000);
        confirmDeleteButton.waitUntilVisible();
        confirmDeleteButton.click();
    }

}
