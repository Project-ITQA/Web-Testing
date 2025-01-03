package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.BuzzSteps;
import utils.TestUtils;

public class AddBuzzPostStepDefinitions {
    @Steps
    BuzzSteps buzzSteps;

    @Given("user is on buzz page")
    public void user_is_on_buzz_page() {
        buzzSteps.openBuzzPage();
    }

    @When("user types {string} on post input field")
    public void user_types_on_post_input_field(String content) {
        TestUtils.addDelay(2000);
        buzzSteps.typeIntoPost(content);
    }

    @And("user clicks on the post button")
    public void user_clicks_on_the_post_button() {
        TestUtils.addDelay(3000);
        buzzSteps.clickPostButton();
    }

    @Then("user can see the post with content {string}")
    public void user_can_see_the_post_with_content(String content) {
        buzzSteps.verifyPostAvailable(content);
    }
}
