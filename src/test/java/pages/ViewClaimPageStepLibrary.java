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

    @Step
    public void clickAddButton(){
        viewClaimPage.clickAddButton();
    }

    @Step
    public void verifyAddExpenseModal(){
        viewClaimPage.verifyAddExpenseModal();
    }

    @Step
    public void selectExpenseType(String expenseType){
        viewClaimPage.selectExpenseType(expenseType);
    }

    @Step
    public void enterExpenseAmount(String expenseAmount){
        viewClaimPage.enterExpenseAmount(expenseAmount);
    }

    @Step
    public void enterExpenseDate(String expenseDate){
        viewClaimPage.enterExpenseDate(expenseDate);
    }

    @Step
    public void enterExpenseNote(String note){
        viewClaimPage.enterExpenseNote(note);
    }

    @Step
    public void clickSaveButton(){
        viewClaimPage.clickSaveButton();
    }

    @Step
    public void verifyExpenseDetails(String expenseType, String amount, String date, String note){
        viewClaimPage.verifyExpenseDetails(expenseType, amount, date, note);
    }

    @Step
    public void clickSubmitButton(){
        viewClaimPage.clickSubmitButton();
    }

    @Step
    public void verifyClaimStatus(String status){
        viewClaimPage.verifyClaimStatus(status);
    }

    @Step
    public void verifyExpenseFieldRequiredMessage(){
        viewClaimPage.verifyRequiredMessage();
    }

}
