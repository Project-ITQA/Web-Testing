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

    @FindBy(xpath ="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span[contains(@class, 'oxd-text')]")
    private WebElementFacade searchResultPhrase;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button--secondary') and text()=' Search ']")
    private WebElementFacade searchButton;


    public void clickAddUserButton (){
        addUserButton.click();
    }

    public void verifyCurrentPage()
    {
        String currentURL = (getDriver().getCurrentUrl());
        System.out.println(currentURL);
        assert currentURL != null;
        Assert.assertTrue(currentURL.contains("admin/viewSystemUsers"));
    }

    public void checkUsername(String username){
     usernameField.sendKeys(username);
     userSearchButton.click();
        searchResultPhrase.waitUntilVisible();
     Assert.assertTrue(searchResultPhrase.containsText("(1)"));

    }

    public void typeIntoSearchBox(String text) {
        usernameField.waitUntilVisible();
        usernameField.sendKeys(text);
    }

    public void clickSearchButton(){
        searchButton.waitUntilVisible();
        searchButton.click();
    }

}
