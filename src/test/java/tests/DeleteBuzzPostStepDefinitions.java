package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.BuzzSteps;
import utils.TestUtils;

public class DeleteBuzzPostStepDefinitions {
    @Steps
    BuzzSteps buzzSteps;

    @And("user clicks the options button of the post {string}")
    public void user_clicks_the_options_button_of_the_post(String content) {
        buzzSteps.clickOptionsButton(content);
    }

    @When("user clicks the delete button")
    public void user_clicks_the_delete_button() {
        buzzSteps.clickDeleteButton();
        buzzSteps.clickConfirmDeleteButton();
        TestUtils.addDelay(2000);
    }

    @Then("user can't see the post with the content {string}")
    public void user_can_see_the_post_with_the_content(String content) {
        buzzSteps.verifyPostisDeleted(content);
    }
}
