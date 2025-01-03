package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class OrangeHrmEditJobPage extends PageObject {

    @FindBy(xpath = "//label[text()='Job Title']/following::input[contains(@class, 'oxd-input')]")
    private WebElementFacade title;

    @FindBy (xpath = "//button[contains(@class, 'oxd-button') and contains(., 'Save')]")
    private WebElementFacade saveButton;

    public void fillJobTitle(String title) {
        this.title.sendKeys(Keys.CONTROL + "a"); // Select all text
        this.title.sendKeys(Keys.DELETE); // Delete the selected text
        this.title.sendKeys(title);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public void verifyEditJobPage() {
        String currentURL = getDriver().getCurrentUrl();
        Assert.assertTrue(currentURL.contains("saveJobTitle"));
    }
}
