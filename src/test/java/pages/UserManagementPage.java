package pages;

import net.serenitybdd.annotations.DefaultUrl;
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

    @FindBy(xpath ="//span[contains(@class, 'oxd-text') and contains(text(), 'Records Found')]")
    private WebElementFacade searchResultPhrase;

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
        TestUtils.addDelay(3000);
     Assert.assertTrue(searchResultPhrase.containsText("(1)"));

    }
}
