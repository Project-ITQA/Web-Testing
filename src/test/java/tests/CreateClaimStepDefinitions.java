package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.ClaimsPageStepLibrary;
import pages.SubmitClaimPageStepLibrary;
import pages.ViewClaimPageStepLibrary;

public class CreateClaimStepDefinitions {

    @Steps
    ClaimsPageStepLibrary claimsPageStepLibrary ;

    @Steps
    SubmitClaimPageStepLibrary submitClaimPageStepLibrary;

    @Steps
    ViewClaimPageStepLibrary viewClaimPageStepLibrary;

    @Given("the user is on the Claims Page")
    public void the_user_is_on_the_claims_page() {
        claimsPageStepLibrary.openClaimsPage();
    }

    @When("the user clicks the Submit Claim button")
    public void the_user_clicks_the_submit_claim_button() {
        claimsPageStepLibrary.clickSubmitClaimButton();
    }

    @When("the user is navigated to the Submit Claim page")
    public void the_user_is_navigated_to_the_submit_claim_page() {
        submitClaimPageStepLibrary.verifySubmitClaimPage();
    }

    @When("the user selects the Event {string}")
    public void the_user_selects_the_event(String string) {
        submitClaimPageStepLibrary.selectEvent(string);
    }

    @When("the user selects the Currency {string}")
    public void the_user_selects_the_currency(String string) {
        submitClaimPageStepLibrary.selectCurrency(string);
    }

    @When("the user enters Remarks {string}")
    public void the_user_enters_remarks(String string) {
        submitClaimPageStepLibrary.enterRemarks(string);
    }

    @When("the user clicks the Create button")
    public void the_user_clicks_the_create_button() {
        submitClaimPageStepLibrary.clickCreateButton();
    }

    @Then("the user is directed to the View Claim page")
    public void the_user_is_directed_to_the_view_claim_page() {
        viewClaimPageStepLibrary.verifyNavigateToViewClaimPage();
    }

    @Then("the user should see the claim details Event {string} and Currency {string} and Remarks {string}")
    public void the_user_should_see_the_claim_details_event_and_currency_and_remarks(String string, String string2, String string3) {
        viewClaimPageStepLibrary.verifyClaimDetails(string, string2, string3);
    }

    @Then("User can see the required message under the currency field")
    public void userCanSeeTheRequiredMessageUnderTheCurrencyField() {
        submitClaimPageStepLibrary.verifyCurrencyFieldRequiredMessage();
    }
}
