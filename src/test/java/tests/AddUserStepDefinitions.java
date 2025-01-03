package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.UserManagementPageStepLibrary;
import steps.UserPageAddStepLibrary;
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

    @When("User clicks on the Add button in user management")
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

    @And("User fills the user role {string} and status {string} and username {string} and password {string} and confirm password as {string}")
    public void user_does_not_fill_mandatory_fields(String user_role, String status, String username, String password, String confirm_password) {
        addUserPage.fillUserRole(user_role);
        addUserPage.fillStatus(status);
        addUserPage.fillUsername(username);
        addUserPage.fillPassword(password);
        addUserPage.fillConfirmPassword(confirm_password);
        TestUtils.addDelay(3000);
    }

    @And("User fills the user role {string} and employee name {string} and status {string} and username {string} and password as {string}")
    public void user_does_not_fill_Confirm_Password_mandatory_field(String user_role, String employee_name, String status, String username, String password) {
        addUserPage.fillUserRole(user_role);
        addUserPage.fillEmployeeName(employee_name);
        addUserPage.fillStatus(status);
        addUserPage.fillUsername(username);
        addUserPage.fillPassword(password);
        TestUtils.addDelay(3000);
    }

    @Then("User is getting the error under the employee Name field")
    public void User_is_getting_the_error_under_the_employee_Name_field(){
        addUserPage.verifyRequiredMessage();
    }

    @Then("User is getting the error under the Confirm Password field")
    public void User_is_getting_the_error_under_the_Confirm_Password_field(){
        addUserPage.verifyPasswordDoNotMatchMessage();
    }

    @When("User clicks the submit button in user management")
    public void user_clicks_the_submit_button() {
        addUserPage.clickSubmitButton();
        TestUtils.addDelay(3000);
    }

    @Then("User is directed to the view user page")
    public void user_is_directed_to_the_view_user_page() {
        TestUtils.addDelay(3000);
        userPage.verifyCurrentPage();

    }
    @Then("User can see user {string}")
    public void user_can_see_user(String username) {
        TestUtils.addDelay(3000);
        userPage.checkUsername(username);
    }

}
