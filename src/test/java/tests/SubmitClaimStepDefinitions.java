package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.ViewClaimPageStepLibrary;

public class SubmitClaimStepDefinitions {

    @Steps
    ViewClaimPageStepLibrary viewClaimPageStepLibrary;

    @When("the user clicks the Add Expenses button")
    public void the_user_clicks_the_add_expenses_button() {
        viewClaimPageStepLibrary.clickAddButton();
    }

    @Then("the add expenses modal should be displayed")
    public void the_add_expenses_modal_should_be_displayed() {
        viewClaimPageStepLibrary.verifyAddExpenseModal();
    }

    @Then("the user selects the Expense Type {string}")
    public void the_user_selects_the_expense_type(String string) {
        viewClaimPageStepLibrary.selectExpenseType(string);
    }

    @Then("the user enters the Amount {string}")
    public void the_user_enters_the_amount(String string) {
        viewClaimPageStepLibrary.enterExpenseAmount(string);
    }

    @And("the user enters the Date {string}")
    public void theUserEntersTheDate(String arg0) {
        viewClaimPageStepLibrary.enterExpenseDate(arg0);
    }

    @Then("the user enters the Note {string}")
    public void the_user_enters_the_note(String string) {
        viewClaimPageStepLibrary.enterExpenseNote(string);
    }

    @Then("the user clicks the save button")
    public void the_user_clicks_the_save_button() {
        viewClaimPageStepLibrary.clickSaveButton();
    }

    @Then("the user should see the expense details Expense Type {string} and Amount {string} and Date {string} and Note {string}")
    public void the_user_should_see_the_expense_details_expense_type_and_amount_and_date_and_note(String string, String string2, String string3, String string4) {
        viewClaimPageStepLibrary.verifyExpenseDetails(string, string2, string3, string4);
    }

    @When("the user clicks the Submit button")
    public void the_user_clicks_the_submit_button() {
        viewClaimPageStepLibrary.clickSubmitButton();
    }

    @Then("the user should see the claim status as {string}")
    public void the_user_should_see_the_claim_status_as(String string) {
        viewClaimPageStepLibrary.verifyClaimStatus(string);
    }

    @Then("the user should see a required message under the Expenses field")
    public void theUserShouldSeeARequiredMessageUnderTheExpensesField() {
        viewClaimPageStepLibrary.verifyExpenseFieldRequiredMessage();
    }
}
