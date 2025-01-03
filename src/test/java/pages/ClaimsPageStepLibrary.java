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

    @Step
    public void selectEvent(String event){
        claimsPage.selectDropDownOption("Event Name", event);
    }

    @Step
    public void selectStatus(String status){
        claimsPage.selectDropDownOption("Status", status);
    }

    @Step
    public void selectReferenceNumber(){
        claimsPage.selectReferenceId();
    }

    @Step
    public void clickSearchButton(){
        claimsPage.clickSearchButton();
    }

    @Step
    public void verifyClaimDetails(String event, String currency, String remarks){
        claimsPage.verifyOnlyOneRowExists(event, currency, remarks);
    }
}
