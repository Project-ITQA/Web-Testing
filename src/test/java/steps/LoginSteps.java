package steps;

import pages.LoginPage;
import utils.TestUtils;
import net.serenitybdd.annotations.Step;

public class LoginSteps {

LoginPage loginPage;

    @Step("Opening Page")
    public void OpenAppication()
    {
        loginPage.open();
        TestUtils.addDelay(3000);
    }

    @Step("Entering username as {0}")
    public void EnterUserName(String username)
    {
        loginPage.enterusername(username);
    }

    @Step("Entering password as {0}")
    public void EnterPasword(String password)
    {
loginPage.enteruserpw(password);
    }

    @Step("Clicking Login Button")
    public void ClickLoginButton()
    {
loginPage.clickLogin();
    }
}
