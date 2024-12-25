package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pages.DashboardSteps;
import pages.LoginSteps;

public class EmployeeManagement {
    @Steps
    LoginSteps home;

    @Steps
    DashboardSteps dash;

    @Given("user is on the Add Employee page")
    public void userIsOnHomePage() {
        home.OpenAppication();
    }

    @When("user enters valid employee details")
    public void userEnterUsername(String username) {
        home.EnterUserName(username);
    }

    @When("user saves the new employee")
    public void userEnterPassword(String password) {
        home.EnterPasword(password);
        home.ClickLoginButton();
    }

    @Then("user should see the employee in the employee list")
    public void userShouldBeAbleToLogin() {
        dash.VerifyAdminLogin();
    }
}