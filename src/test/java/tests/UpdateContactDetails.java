package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.CommonSteps;
import steps.DashboardSteps;
import steps.MyInfoSteps;
import utils.TestUtils;

public class UpdateContactDetails {
    @Steps
    MyInfoSteps myInfoSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Steps
    CommonSteps commonSteps;

    @When("the user navigates to the {string} tab")
    public void theUserNavigatesToTheTab(String tabName) {
        dashboardSteps.navigateToTab(tabName);
        TestUtils.addDelay();
    }

    @Then("the user should be on the My Info page")
    public void theUserShouldBeOnTheMyInfoPage() {
        myInfoSteps.verifyOnMyInfoPage();
    }

    @When("the user navigates to {string} section")
    public void theUserNavigatesToSection(String sectionName) {
        myInfoSteps.navigateToSection(sectionName);
        TestUtils.addDelay();
    }


    @Then("the user should be on the {string} section")
    public void theUserShouldBeOnSection(String sectionName) {
        myInfoSteps.verifyOnSection(sectionName);
    }

    @When("the user updates their contact details by typing values - {string}")
    public void theUserUpdatesTheirContactDetailsWithValuesByTyping(String valuePairs) {
        commonSteps.fillInputFieldsHavingLabels(valuePairs);
    }

    @And("the user updates their contact details by selecting options with values - {string}")
    public void theUserUpdatesTheirContactDetailsWithValuesBySelecting(String valuePairs) {
        commonSteps.selectDropdownOptionsWithLabels(valuePairs);
    }

    @Then("a toast with {string} message should be displayed")
    public void aToastWithMessageShouldBeDisplayed(String message) {
        commonSteps.checkToastPopUpWithMessage(message);
    }

    @And("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String buttonName) {
        commonSteps.clickOnButtonHavingLabel(buttonName);
        TestUtils.addDelay();
    }
}
