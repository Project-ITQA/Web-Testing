package pages;

import net.serenitybdd.annotations.Step;

public class ClaimsPageStepLibrary {

    OrangeHrmClaimsPage claimsPage;

    @Step
    public void openClaimsPage(){
        claimsPage.open();
    }

    @Step
    public void clickSubmitClaimButton(){
        claimsPage.clickSubmitClaimButton();
    }
}
