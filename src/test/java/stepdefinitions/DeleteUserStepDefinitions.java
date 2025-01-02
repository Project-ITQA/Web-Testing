package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UserManagementPage;
import pages.UserManagementPageStepLibrary;
import utils.TestUtils;

public class DeleteUserStepDefinitions {
    UserManagementPageStepLibrary userManagementPageStepLibrary;

    @When("User clicks on the Delete button of {string}")
    public void userClicksOnTheDeleteButton(String username) {
        userManagementPageStepLibrary.clickDeleteButton(username);
    }

    @When("User clicks on the confirm button")
    public void userClicksOnTheConfirmButton() {
        userManagementPageStepLibrary.clickConfirmDeleteButton();
    }

    @Then("User cannot see {string}")
    public void userCannotSeeUserInUserTable(String username) {
        TestUtils.addDelay(4000);
        userManagementPageStepLibrary.verifyUserRowNonAvailability(username);
    }
}
