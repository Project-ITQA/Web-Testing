package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.ClaimsPageStepLibrary;
import pages.ViewClaimPageStepLibrary;

public class SearchClaimStepDefinitions {

    @Steps
    ClaimsPageStepLibrary claimsPageStepLibrary ;

    @Steps
    ViewClaimPageStepLibrary viewClaimPageStepLibrary;

    @Given("the user selects the Event {string} in the search field")
    public void the_user_selects_the_event_in_the_search_field(String string) {
        claimsPageStepLibrary.selectEvent(string);
    }

    @Given("the user selects the Status {string} in the search field")
    public void the_user_selects_the_status_in_the_search_field(String string) {
        claimsPageStepLibrary.selectStatus(string);
    }

    @Given("the user selects the reference number in the search field")
    public void the_user_selects_the_reference_number_in_the_search_field() {
        claimsPageStepLibrary.selectReferenceNumber();
    }

    @When("the user clicks the search button")
    public void the_user_clicks_the_search_button() {
        claimsPageStepLibrary.clickSearchButton();
    }

    @Then("the user should only see the claim details Event {string} and Currency {string} and Remarks {string} in the search result")
    public void the_user_should_only_see_the_claim_details_event_and_currency_and_remarks_in_the_search_result(String string, String string2, String string3) {
        claimsPageStepLibrary.verifyClaimDetails(string, string2, string3);
    }
}
