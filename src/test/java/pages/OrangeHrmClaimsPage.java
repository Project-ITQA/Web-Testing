package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/claim/viewAssignClaim")
public class OrangeHrmClaimsPage extends PageObject {

    @FindBy(xpath = "//li[contains(@class, 'oxd-topbar-body-nav-tab')]//a[text()='Submit Claim']" )
    private WebElementFacade submitClaimButton;

    public void clickSubmitClaimButton(){
        submitClaimButton.click();
    }
}
