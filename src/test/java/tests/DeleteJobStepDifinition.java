package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.JobListPageSteps;

public class DeleteJobStepDifinition {

    @Steps
    JobListPageSteps jobListPageSteps;

    @Given("User can see {string} in JobList Table")
    public void userCanSeeJobListTable(String title) {
        jobListPageSteps.verifyJobRowAvailability(title);
    }

    @When("user clicks on the Delete button of {string}")
    public void user_clicks_on_the_delete_button_of(String title) {
        jobListPageSteps.clickDeleteButton(title);
    }

    @When("User clicks on the confirm Button in job management")
    public void userClicksOnTheConfirmButton() {
        jobListPageSteps.clickConfirmDeleteButton();
    }

    @Then("User cannot see {string} in JobList table")
    public void user_cannot_see_in_job_list_table(String title) {
        jobListPageSteps.verifyJobRowNonAvailability(title);
    }

}
