package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;

import java.util.List;


@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser")
public class UserPageAdd extends PageObject {

    @FindBy(xpath = "//label[normalize-space()='User Role']/following::div[contains(@class, 'oxd-select-wrapper')][1]")
    private WebElementFacade userRoleField;

    @FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
    private List<WebElementFacade> userRoleOptions;

    @FindBy(name = "employeeName")
    private WebElementFacade employeeNameField;

    @FindBy(name = "status")
    private WebElementFacade statusField;

    @FindBy(name = "username")
    private WebElementFacade usernameField;

    @FindBy(name = "password")
    private WebElementFacade passwordField;

    @FindBy(name = "confirmPassword")
    private WebElementFacade confirmPasswordField;

    @FindBy(css = "button[type='submit']")
    private WebElementFacade submitButton;

    public void fillUserRole(String userRole) {
        userRoleField.click();
        for (WebElementFacade option :
                userRoleOptions) {
            option.waitUntilVisible();
            if (option.containsText(userRole)) {
                option.click();
                break;
            }
        }
    }

    public void fillEmployeeName(String employeeName) {
        userRoleField.sendKeys(employeeName);
    }

    public void fillStatus(String status) {
        userRoleField.sendKeys(status);
    }

    public void fillUsername(String username) {
        userRoleField.sendKeys(username);
    }

    public void fillPassword(String password) {
        userRoleField.sendKeys(password);
    }

    public void fillConfirmPassword(String confirmPassword) {
        userRoleField.sendKeys(confirmPassword);
    }

    public void verifyCurrentPage() {
        String currentURL = (getDriver().getCurrentUrl());
        System.out.println(currentURL);
        assert currentURL != null;
        Assert.assertTrue(currentURL.contains("admin/saveSystemUser"));
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

}
