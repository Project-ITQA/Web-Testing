package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.exceptions.NoSuchElementException;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate")
public class OrangeHrmAddCandidatePage extends PageObject {
    @FindBy(name="firstName")
    private WebElementFacade firstNameField;

    @FindBy(name="lastName")
    private WebElementFacade lastNameField;

    @FindBy(xpath = "//label[text()='Email']/ancestor::div[contains(@class, 'oxd-input-group')]//input")
    private WebElementFacade emailField;

    @FindBy(css = "button[type='submit']")
    private WebElementFacade submitButton;

    public void fillFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void fillEmail(String email) {
        emailField.sendKeys(email);
    }

    public void verifyCurrentPage()
    {
        String currentURL = (getDriver().getCurrentUrl());
        System.out.println(currentURL);
        assert currentURL != null;
        Assert.assertTrue(currentURL.contains("recruitment/addCandidate"));
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void verifyEmailRequiredMessage(){
        try {
            WebElementFacade requiredMessage = find(By.xpath("//label[text()='Email']/ancestor::div[contains(@class, 'oxd-input-group')]/descendant::span[text()='Required']"));
            requiredMessage.waitUntilVisible();
            Assert.assertTrue(requiredMessage.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Email required message is not shown");
        }
    }
}
