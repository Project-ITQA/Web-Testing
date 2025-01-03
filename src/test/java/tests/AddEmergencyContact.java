package tests;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.CommonSteps;
import steps.MyInfoSteps;
import utils.TestUtils;

public class AddEmergencyContact {
    @Steps
    MyInfoSteps myInfoSteps;

    @Steps
    CommonSteps commonSteps;

    @When("the user clicks on the {string} button in {string} space")
    public void theUserClicksOnTheButtonInSpace(String buttonLabel, String spaceTitle) {
        myInfoSteps.clickTheButtonInTheSpace(spaceTitle, buttonLabel);
    }

    @When("the user enter the emergency contact details by typing values - {string}")
    public void theUserEnterTheEmergencyContactDetailsByTypingValuesString(String valuePairs) {
        commonSteps.fillInputFieldsHavingLabels(valuePairs);
    }

    @Then("the user should see a record with {string}")
    public void theUserShouldSeeARecordWithAs(String value) {
        TestUtils.addDelay();
        commonSteps.checkIfTheRecordIsAvailable(value);
    }
}
