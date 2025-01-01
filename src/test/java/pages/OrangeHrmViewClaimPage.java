package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

public class OrangeHrmViewClaimPage extends PageObject {

    @FindBy(xpath = "//label[text()='Event']/following::input[@class='oxd-input oxd-input--active' and @disabled]")
     private WebElementFacade eventField;

    @FindBy(xpath = "//label[text()='Currency']/following::input[@class='oxd-input oxd-input--active' and @disabled]")
    private WebElementFacade currencyField;

    @FindBy(xpath = "//label[text()='Reference Id']/following::input[@class='oxd-input oxd-input--active' and @disabled]")
    private WebElementFacade ReferenceIdField;

    @FindBy(xpath = "//label[text()='Remarks']/following::textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical' and @disabled]")
    private WebElementFacade remarksField;

    public void verifyViewClaimPage(){
        String currentURL = getDriver().getCurrentUrl();
        Assert.assertTrue(currentURL.contains("id"));
    }

    public void verifyClaimDetails(String event, String currency, String remarks){
        Assert.assertEquals(event, eventField.getDomProperty("_value"));
        Assert.assertEquals(currency, currencyField.getDomProperty("_value"));
        Assert.assertEquals(remarks, remarksField.getDomProperty("_value"));
    }

    public String getReferenceId(){
        return ReferenceIdField.getDomProperty("_value");
    }
}
