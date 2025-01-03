package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import utils.TestUtils;

import java.util.List;
import java.util.NoSuchElementException;


@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveSystemUser")
public class UserPageAdd extends PageObjectBase {

    @FindBy(xpath = "//label[normalize-space()='User Role']/following::div[contains(@class, 'oxd-select-wrapper')][1]")
    private WebElementFacade userRoleField;

    @FindBy(xpath = "//label[normalize-space()='Status']/following::div[contains(@class, 'oxd-select-wrapper')][1]")
    private WebElementFacade statusField;

    @FindBy(xpath = "//div[@role='listbox']//div[@role='option']")
    private List<WebElementFacade> currentVisibleOptions;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    private WebElementFacade employeeNameField;

    @FindBy(xpath = "//label[normalize-space()='Username']/following::div//input")
    private WebElementFacade usernameField;

    @FindBy(xpath = "//label[normalize-space()='Password']/following::div//input")
    private WebElementFacade passwordField;

    @FindBy(xpath = "//label[normalize-space()='Confirm Password']/following::div//input")
    private WebElementFacade confirmPasswordField;

    @FindBy(css = "button[type='submit']")
    private WebElementFacade submitButton;

    @FindBy(xpath = "//span[contains(@class, 'oxd-input-field-error-message') and text()='Required']")
    private WebElementFacade requiredMessage;

    @FindBy(xpath="//span[contains(@class, 'oxd-input-field-error-message') and text()='Passwords do not match']")
    private WebElementFacade passwordDoNotMatchMessage;

    public void fillUserRole(String userRole) {
        userRoleField.click();
        TestUtils.selectOptionFrom(currentVisibleOptions,userRole);
    }

    public void fillStatus(String status) {
        statusField.click();
        TestUtils.selectOptionFrom(currentVisibleOptions,status);
    }

    public void fillEmployeeName(String employeeName) {
        employeeNameField.sendKeys(employeeName);
        TestUtils.addDelay(3000);
        TestUtils.selectOptionFrom(currentVisibleOptions,employeeName);
    }

    public void fillUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void fillPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void fillConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
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

    public void verifyRequiredMessage(){
        try {
            requiredMessage.waitUntilVisible();
            Assert.assertTrue(requiredMessage.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Employee Name required message is not shown");
        }
    }

    public void verifyPasswordDoNotMatchMessage(){
        try {
            passwordDoNotMatchMessage.waitUntilVisible();
            Assert.assertTrue(passwordDoNotMatchMessage.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Password do not match message is not shown");
        }
    }

}
