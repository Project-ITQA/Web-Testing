package tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.DashboardSteps;
import steps.EmployeeSteps;

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

    @When("user enters valid employee details {string} and {string} and {string}")
    public void userEnterUsername(String firstName, String lastName, String empId) {

        employeeSteps.enterEmployeeDetails(firstName, lastName, empId);
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


    @When("user enters invalid employee details {string} and {string} and {string}")
    public void userEntersInvalidEmployeeDetails(String firstName, String lastName , String empId) {
        employeeSteps.enterEmployeeDetails(firstName, lastName , empId);
    }

    @Then("user should not be redirected to employee details page")
    public void userShouldNotBeRedirectedToEmployeeDetailsPage() {
        employeeSteps.verifyNoRedirectionToPersonalDetails();
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


    @Then("user navigate to Employee List tab")
    public void userNavigateToEmployeeListTab() {
        employeeSteps.userNavigateToEmployeeListTab();
    }

    @And("user search for {string} employee")
    public void userSearchForEmployee(String arg0) {
        employeeSteps.searchEmployee(arg0);
    }

    @Then("user get the serch results")
    public void userGetTheSerchResults() {
        employeeSteps.thereAreSearchResult();
    }

    @And("user delete the employee")
    public void userFilterCorrectUserByAndClickDelete() {
        employeeSteps.deleteRowByEmpID();
    }

    @Then("user click yes in pop-up")
    public void userClickYesInPopUp() {
    employeeSteps.userClickYesInPopUp();
    }

    @And("user get No Records Found on the table")
    public void userGetNoRecordsFoundOnTheTable() {
    }





}