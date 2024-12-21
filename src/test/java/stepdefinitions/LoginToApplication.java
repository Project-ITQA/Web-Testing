package stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import pages.Dashboard;
import pages.Homepage;

public class LoginToApplication {
    @Steps
    Homepage home;

    @Steps
    Dashboard dash;

    @Given("user is on home page")
    public void userIsOnHomePage() {
        home.OpenAppication();
    }

    @When("user enters {string} as username")
    public void userEnterUsername(String username) {
        home.EnterUserName(username);
    }

    @When("user enters {string} as password")
    public void userEnterPassword(String password) {
        home.EnterPasword(password);
        home.ClickLoginButton();
    }

    @Then("user should be able to login")
    public void userShouldBeAbleToLogin() {
        dash.VerifyAdminLogin();
    }
}