package pages;

import net.serenitybdd.annotations.Step;

public class SubmitClaimPageStepLibrary {

    OrangeHrmSubmitClaimPage submitClaimPage;

    @Step
    public void verifySubmitClaimPage(){
        submitClaimPage.verifyNavigateToSubmitClaimPage();
    }

    @Step
    public void selectEvent(String event){
        submitClaimPage.selectEvent(event);
    }

    @Step
    public void selectCurrency(String currency){
        submitClaimPage.selectCurrency(currency);
    }

    @Step
    public void enterRemarks(String remarks){
        submitClaimPage.enterRemarks(remarks);
    }

    @Step
    public void clickCreateButton(){
        submitClaimPage.clickCreateButton();
    }

    @Step
    public void verifyCurrencyFieldRequiredMessage(){
        submitClaimPage.verifyCurrencyFieldRequiredMessage();
    }
}
