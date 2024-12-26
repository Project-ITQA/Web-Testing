package stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import pages.DashboardSteps;
import pages.LoginSteps;

public class LoginToApplication {
    @Steps
    LoginSteps home;

    @Steps
    DashboardSteps dash;


    @Given("user is on home page")
    public void userIsOnHomePage() {
        home.OpenAppication();
    }

    @When("user enters {string} as username")
    public void userEnterUsername(String username) {
        home.EnterUserName(username);
    }

    @And("user enters {string} as password")
    public void userEnterPassword(String password) {
        home.EnterPasword(password);
        home.ClickLoginButton();
    }

    @Then("user should be able to login")
    public void userShouldBeAbleToLogin() {
        dash.VerifyAdminLogin();
    }
}