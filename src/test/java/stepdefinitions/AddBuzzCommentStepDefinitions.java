package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.BuzzSteps;
import utils.TestUtils;

public class AddBuzzCommentStepDefinitions {
    @Steps
    BuzzSteps buzzSteps;

    @When("user clicks on the comment button of the post with content {string}")
    public void when_user_clicks_on_the_comment_button(String content) {
        buzzSteps.clickCommentButton(content);
        TestUtils.addDelay(3000);
    }

    @And("user types the comment {string} and Enter for the post {string}")
    public void user_types_the_comment_and_Enter(String comment, String content) {
        buzzSteps.typeComment(content, comment);
    }

    @Then("user can see the comment {string} for the post {string}")
    public void user_can_see_the_comment_for_the_post(String comment, String content) {
        TestUtils.addDelay(3000);
        buzzSteps.verifyCommentAvailable(content, comment);
    }
}
