package tests;

import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.UserManagementPageStepLibrary;

public class SearchUserStepDefinitions {

    @Steps
    UserManagementPageStepLibrary userManagementPageStepLibrary;

    @When("User types {string} in the search box in user management")
    public void user_types_in_the_search_box(String username) {
        userManagementPageStepLibrary.typeIntoSearchBox(username);
    }
    @When("User clicks the Search button in user management")
    public void user_clicks_the_Search_button() {
        userManagementPageStepLibrary.clickSearchButton();
    }

}
