package tests;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import steps.DashboardSteps;
import steps.LoginSteps;

public class LoginToApplication {
    @Steps
    LoginSteps loginSteps;

    @Steps
    DashboardSteps dashboardSteps;

    @Given("user is on home page")
    public void userIsOnHomePage() {
        loginSteps.OpenAppication();
    }

    @When("user enters {string} as username")
    public void userEnterUsername(String username) {
        loginSteps.EnterUserName(username);
    }

    @When("user enters {string} as password")
    public void userEnterPassword(String password) {
        loginSteps.EnterPasword(password);
        loginSteps.ClickLoginButton();
    }

    @Then("user should be on dashboard page")
    public void userShouldBeOnDashboardPage() {
        dashboardSteps.verifyIsOnDashboardPage();
    }
}