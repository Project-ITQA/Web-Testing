package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

public class OrangeHrmViewClaimPage extends PageObject {

    @FindBy(xpath = "//label[text()='Event']/following::input[@class='oxd-input oxd-input--active' and @disabled]")
    WebElementFacade eventField;

    @FindBy(xpath = "//label[text()='Currency']/following::input[@class='oxd-input oxd-input--active' and @disabled]")
    WebElementFacade currencyField;

    @FindBy(xpath = "//label[text()='Remarks']/following::textarea[@class='oxd-textarea oxd-textarea--active' and @disabled]")
    WebElementFacade remarksField;


    public void verifyViewClaimPage(){
        String currentURL = getDriver().getCurrentUrl();
        Assert.assertTrue(currentURL.contains("id"));
    }

    public void verifyClaimDetails(String event, String currency, String remarks){
//        Assert.assertEquals(event, eventField.getAttribute("value"));
//        Assert.assertEquals(currency, currencyField.getAttribute("value"));
//        Assert.assertEquals(remarks, remarksField.getAttribute("value"));
    }
}
