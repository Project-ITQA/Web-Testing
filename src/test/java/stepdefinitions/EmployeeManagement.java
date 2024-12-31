package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.DashboardSteps;
import pages.EmployeeSteps;

public class EmployeeManagement {
    @Steps
    EmployeeSteps employeeSteps;

    @Steps
    DashboardSteps dashboardSteps;


    @Given("user is logged in as an Admin")
    public void userIsLoggedInAsAdmin() {
        employeeSteps.loginAsAdmin();
    }

    @Given("user navigates to the Add Employee page")
    public void navigateToAddEmployeePage() {

        employeeSteps.navigateToAddEmployeePage();
    }

    @When("user enters valid employee details {string} and {string}")
    public void userEnterUsername(String firstName, String lastName) {

        employeeSteps.enterEmployeeDetails(firstName, lastName);
    }

    @And("user saves the new employee")
    public void userEnterPassword() {
        employeeSteps.saveEmployee();
    }

    @Then("user should see the employee {string} in the employee list")
    public void userShouldSeeEmployeeInTheEmployeeList(String fullName) {

        employeeSteps.redirectToViewPersonalDetails();
        employeeSteps.verifyEmployeeDetails(fullName);
    }


    @When("user enters invalid employee details {string} and {string}")
    public void userEntersInvalidEmployeeDetails(String firstName, String lastName) {
        employeeSteps.enterEmployeeDetails(firstName, lastName);
    }

    @Then("user should not be redirected to employee details page")
    public void userShouldNotBeRedirectedToEmployeeDetailsPage() {
        employeeSteps.verifyNoRedirectionToPersonalDetails();
    }

    @Then("user should not see the invalid employee {string} in the employee list")
    public void userShouldNotSeeInvalidEmployeeInEmployeeList(String fullName) {
        employeeSteps.verifyInvalidEmployeeNotInList(fullName);
    }

    @And("user toggles create login details")
    public void userTogglesCreateLoginDetails() {
        employeeSteps.toggleCreateLoginDetails();
    }

    @And("user enters login details {string} and {string}")
    public void userEntersLoginDetails(String username, String password) {
        employeeSteps.enterLoginDetails(username, password);
    }
    @And("user toggles status Enabled")
    public void userTogglesStatusEnabled() {
        employeeSteps.selectEnabledRadioButton();
    }
    @When("user logs out")
    public void userLogsOut() {
        employeeSteps.logout();
    }



//    @When("user logs in with username {string} and password {string}")
//    public void userLogsInWithCredentials(String username, String password) {
//        employeeSteps.loginWithCredentials(username, password);
//    }
//
//    @Then("user should be logged in successfully")
//    public void userShouldBeLoggedInSuccessfully() {
//        employeeSteps.verifySuccessfulLogin();
//    }



}