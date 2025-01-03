package pages;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import utils.TestUtils;

public class OrangeHrmSubmitClaimPage extends PageObject {

    //Event dropdown
    @FindBy(xpath = "//label[text()='Event']/following::div[@class='oxd-select-text oxd-select-text--active'][1]")
    private WebElementFacade eventDropdown;

    //List of events
    @FindBy(xpath = "//label[text()='Event']/following::div[@role='listbox'][1]")
    private WebElementFacade eventOptions;

    //Currency dropdown
    @FindBy(xpath = "//label[text()='Currency']/following::div[@class='oxd-select-text oxd-select-text--active'][1]")
    private WebElementFacade currencyDropdown;

    //List of currencies
    @FindBy(xpath = "//label[text()='Currency']/following::div[@role='listbox'][1]")
    private WebElementFacade currencyOptions;

    @FindBy(xpath = "//label[text()='Remarks']/following::textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']")
    private WebElementFacade remarks;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElementFacade createButton;

    public void verifyNavigateToSubmitClaimPage(){
        String currentURL = (getDriver().getCurrentUrl());
        Assert.assertTrue(currentURL.contains("submitClaim"));
    }

    public void selectEvent(String event){
        eventDropdown.click();
        eventOptions.waitUntilVisible();
        //Select event
        WebElementFacade eventOption = find(By.xpath("//label[text()='Event']/following::div[@role='listbox']//div[@role='option']//span[text()='" + event + "']"));
        if (eventOption == null){
            Assert.fail("Event not found: " + event);
        }
        eventOption.waitUntilVisible().click();
    }

    public void selectCurrency(String currency){
        currencyDropdown.click();
        currencyOptions.waitUntilVisible();
        //Select currency
        WebElementFacade currencyOption = find(By.xpath("//label[text()='Currency']/following::div[@role='listbox']//div[@role='option']//span[text()='" + currency + "']"));
        if (currencyOption == null){
            Assert.fail("Currency not found: " + currency);
        }
        currencyOption.click();
    }

    public void enterRemarks(String remarksText){
        remarks.sendKeys(remarksText);
    }

    public void clickCreateButton(){
        createButton.waitUntilEnabled();
        createButton.click();
        TestUtils.addDelay(5000);
    }

    public void verifyCurrencyFieldRequiredMessage(){
        WebElementFacade currencyField = find(By.xpath("//label[text()='Currency']/following::span[contains(@class, 'oxd-input-field-error-message')]"));
        Assert.assertTrue(currencyField.isDisplayed());
    }

}
