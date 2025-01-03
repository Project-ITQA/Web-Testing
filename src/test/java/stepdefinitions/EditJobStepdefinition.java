package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.EditJobPageStep;
import pages.JobListPageSteps;
import utils.TestUtils;

public class EditJobStepdefinition {

    @Steps
    JobListPageSteps jobListPageSteps;

    @Steps
    EditJobPageStep editJobPageStep;

    @Given("User can see {string} in  Edit JobList Table")
    public void user_can_see_in_edit_job_list_table(String title) {
        jobListPageSteps.verifyJobRowAvailability(title);
    }

    @When("User clicks the Edit button of {string}")
    public void user_clicks_the_edit_button_of(String title) {
        jobListPageSteps.clickEditButton(title);
    }

    @When("User is navigated to the Edit Job page")
    public void user_is_navigated_to_the_add_jobPage() {
        TestUtils.addDelay(3000);
        editJobPageStep.verifyEditJobPage();
    }

    @When("User edits the  job title field to {string}")
    public void user_edits_the_job_title_field_to(String title) {
       editJobPageStep.fillEditJobTitle(title);
    }

    @When("User clicks the Edit page Submit button")
    public void user_clicks_the_edit_page_submit_button() {
        editJobPageStep.clickSubmit();
        TestUtils.addDelay(3000);
    }

    @Then("User is directed to the Job List View page")
    public void user_is_directed_to_the_job_list_view_page() {
        TestUtils.addDelay(3000);
        jobListPageSteps.verifyJoblistPage();
    }

    @Then("User can see Edited job {string} is listed")
    public void user_can_see_edited_job_is_listed(String title) {
        jobListPageSteps.verifyJobTittleAdded(title);
    }
}
