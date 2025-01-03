package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.AddjobPageStep;
import pages.JobListPageSteps;
import utils.TestUtils;

public class AddJobStepDefinition {

    @Steps
    JobListPageSteps jobListPageSteps;

    @Steps
    AddjobPageStep addjobPageSteps;

    @Given("User is on the Job List View page")
    public void userIsOnTheJobListViewPage() {
        jobListPageSteps.openJobListPage();
    }

    @When("User clicks on the Add button")
    public void userClicksOnTheAddButton() {
        jobListPageSteps.clickAddJobButton();
    }

    @When("User is navigated to the Add Job page")
    public void userIsNavigatedToTheAddJobPage() {
        TestUtils.addDelay(3000);
        addjobPageSteps.verifyAddJobPage();
    }

    @When("User fills the job Title {string}")
    public void userFillsTheJobTitle(String jobTitle) {
        addjobPageSteps.fillJobTitle(jobTitle);
        TestUtils.addDelay(3000);
    }

    @When("User clicks the submit button")
    public void userClicksTheSubmitButton() {
        addjobPageSteps.clickSubmit();
        TestUtils.addDelay(3000);
    }

    @Then("User is directed to the  Job List View page")
    public void userIsDirectedToTheJobListViewPage() {
        TestUtils.addDelay(3000);
        jobListPageSteps.verifyJoblistPage();
    }

    @Then("User can see the job {string} listed")
    public void userCanSeeTheJobListed(String jobTitle) {
        jobListPageSteps.verifyJobTittleAdded(jobTitle);
    }
}
