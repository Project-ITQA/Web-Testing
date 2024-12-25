package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.CandidatesPageStepLibrary;
import utils.TestUtils;

public class DeleteCandidateStepDefinitions {
    @Steps
    CandidatesPageStepLibrary candidatesPageStepLibrary;

    @Given("User can see {string} {string} in Candidates table")
    public void userCanSeeCandidatesInCandidatesTable(String firstName, String lastName) {
        candidatesPageStepLibrary.verifyCandidateRowAvailability(firstName, lastName);
    }

    @When("User clicks on the Delete button of {string} {string}")
    public void userClicksOnTheDeleteButton(String firstName, String lastName) {
        candidatesPageStepLibrary.clickDeleteButton(firstName, lastName);
    }

    @When("User clicks on the confirm button")
    public void userClicksOnTheConfirmButton() {
        candidatesPageStepLibrary.clickConfirmDeleteButton();
    }

    @Then("User cannot see {string} {string} in candidates table")
    public void userCannotSeeCandidatesInCandidatesTable(String firstName, String lastName) {
        TestUtils.addDelay(5000);
        candidatesPageStepLibrary.verifyCandidateRowNonAvailability(firstName, lastName);
    }

}
