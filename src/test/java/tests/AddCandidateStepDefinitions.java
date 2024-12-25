package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.AddCandidatesPageStepLibrary;
import pages.CandidatesPageStepLibrary;
import pages.ViewCandidatePageStepLibrary;
import utils.TestUtils;

public class AddCandidateStepDefinitions {

    // Step Libraries for each page object model (no need to initialize objects using new. Done by serenity automatically)
    @Steps
    CandidatesPageStepLibrary candidatesPageStepLibrary;

    @Steps
    AddCandidatesPageStepLibrary addCandidatesPageStepLibrary;

    @Steps
    ViewCandidatePageStepLibrary viewCandidatePageStepLibrary;

    // Tests

    @Given("User is on the Recruitment Candidates page")
    public void user_is_on_the_Recruitment_candidates_page() {
        candidatesPageStepLibrary.openCandidatesPage();
    }

    @When("User clicks on the Add button")
    public void user_clicks_on_the_Add_button() {
        candidatesPageStepLibrary.clickAddCandidateButton();
    }

    @Then("User is navigated to the Add Candidate page")
    public void user_is_navigated_to_the_Add_candidate_page() {
        TestUtils.addDelay(3000);
        addCandidatesPageStepLibrary.verifyAddCandidatePage();
    }

    @And("User fills the first name {string} and last name {string} and email as {string}")
    public void user_fill_mandatory_fields(String first_name, String last_name, String email) {
        addCandidatesPageStepLibrary.fillFirstName(first_name);
        addCandidatesPageStepLibrary.fillLastName(last_name);
        addCandidatesPageStepLibrary.fillEmail(email);
        TestUtils.addDelay(3000);
    }

    @When("User clicks the submit button")
    public void user_clicks_the_submit_button() {
        addCandidatesPageStepLibrary.clickSubmit();
        TestUtils.addDelay(3000);
    }

    @Then("User is directed to the view candidate page")
    public void user_is_directed_to_the_view_candidate_page() {
        TestUtils.addDelay(3000);
        viewCandidatePageStepLibrary.verifyCurrentPage();
    }

    @Then("User can see candidate {string} {string}")
    public void user_can_see_candidate(String firstName, String lastName) {
        viewCandidatePageStepLibrary.checkForCandidateName(firstName,lastName);
    }
}
