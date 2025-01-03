package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.CommonSteps;
import steps.MyInfoSteps;
import utils.TestUtils;

public class DeleteEmergencyContact {
    @Steps
    CommonSteps commonSteps;

    @Steps
    MyInfoSteps myInfoSteps;

    @Then("the user should see a prompt asking {string}")
    public void theUserShouldSeeAPromptAsking(String prompt) {
        commonSteps.checkIfAPromptWithMessageIsVisible(prompt);
        TestUtils.addDelay();
    }

    @And("the user should not see a record with {string}")
    public void theUserShouldNotSeeARecordWith(String value) {
        commonSteps.checkIfNoRecordsAvailableWith(value);
    }

    @When("the user clicks on the {string} icon button in the row with {string}")
    public void theUserClicksOnTheIconButtonInTheRowWith(String type, String value) {
        myInfoSteps.clickOnIconButton(type, value);
    }
}
