package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.UserManagementPageStepLibrary;

public class SearchUserStepDefinitions {

    @Steps
    UserManagementPageStepLibrary userManagementPageStepLibrary;

    @When("User types {string} in the search box")
    public void user_types_in_the_search_box(String username) {
        userManagementPageStepLibrary.typeIntoSearchBox(username);
    }
    @When("User clicks the Search button")
    public void user_clicks_the_Search_button() {
        userManagementPageStepLibrary.clickSearchButton();
    }

}
