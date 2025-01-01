package pages;

import net.serenitybdd.annotations.Step;

public class ViewClaimPageStepLibrary {

    OrangeHrmViewClaimPage viewClaimPage;

    @Step
    public void verifyNavigateToViewClaimPage(){
        viewClaimPage.verifyViewClaimPage();
    }

    @Step
    public void verifyClaimDetails(String event, String currency, String remarks){
        viewClaimPage.verifyClaimDetails(event, currency, remarks);
    }
}
