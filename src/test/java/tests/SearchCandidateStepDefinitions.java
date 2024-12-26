package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.CandidatesPageStepLibrary;

public class SearchCandidateStepDefinitions {
    @Steps
    CandidatesPageStepLibrary candidatesPageStepLibrary;


    @When("User types {string} in the search box")
    public void user_types_in_the_search_box(String fullName) {
        candidatesPageStepLibrary.typeIntoSearchBox(fullName);
    }

    @Then("User see the {string} {string} dropdown item")
    public void user_see_the_dropdown_item(String firstName, String lastName) {
        candidatesPageStepLibrary.verifySearchDropDownItemExists(firstName, lastName);
    }

    @And("User clicks the dropdown item {string} {string}")
    public void user_clicks_the_dropdown_item(String firstName, String lastName) {
        candidatesPageStepLibrary.clickDropDownItem(firstName, lastName);
    }

    @When("User clicks the Search button")
    public void user_clicks_the_Search_button() {
        candidatesPageStepLibrary.clickSearchButton();
    }

    @Then("User can see only {string} {string} in Candidates table")
    public void user_can_see_only_in_candidates_table(String firstName, String lastName) {
        candidatesPageStepLibrary.verifyOnlyOneRowExists(firstName, lastName);
    }
}
