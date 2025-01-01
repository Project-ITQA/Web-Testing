package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.UserManagementPageStepLibrary;
import pages.UserPageAddStepLibrary;
import utils.TestUtils;

public class AddUserStepDefinitions {
    @Steps
    UserManagementPageStepLibrary userPage;

    @Steps
    UserPageAddStepLibrary addUserPage;


    @Given("User is on the Admin User Management page")
    public void user_is_on_the_Admin_User_Management_page(){
        userPage.openUserPage();
    }

    @When("User clicks on the Add button")
    public void user_clicks_on_the_Add_button(){
        userPage.clickUserAddButton();
    }

    @Then("User is navigated to the Add User page")
    public void user_is_navigated_to_the_Add_User_page(){
        TestUtils.addDelay(3000);
        addUserPage.verifyCurrentPage();
    }

    @And("User fills the user role {string} and employee name {string} and status {string} and username {string} and password {string} and confirm password as {string}")
    public void user_fill_mandatory_fields(String user_role, String employee_name, String status, String username, String password, String confirm_password) {
        addUserPage.fillUserRole(user_role);
        addUserPage.fillEmployeeName(employee_name);
        addUserPage.fillStatus(status);
        addUserPage.fillUsername(username);
        addUserPage.fillPassword(password);
        addUserPage.fillConfirmPassword(confirm_password);
        TestUtils.addDelay(3000);
    }

    @When("User clicks the submit button")
    public void user_clicks_the_submit_button() {
        addUserPage.clickSubmitButton();
        TestUtils.addDelay(3000);
    }

    @Then("User is directed to the view user page")
    public void user_is_directed_to_the_view_user_page() {
        TestUtils.addDelay(3000);
        addUserPage.verifyCurrentPage();

    }

    @Then("User can see user {string}")
    public void user_can_see_user(String username) {
        userPage.checkUsername(username);
    }

}
