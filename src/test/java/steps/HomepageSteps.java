package steps;

import pages.LoginPage;
import utils.TestUtils;
import net.serenitybdd.annotations.Step;

public class HomepageSteps {

LoginPage homepage;

    @Step("Opening Page")
    public void OpenAppication()
    {
        homepage.open();
        TestUtils.addDelay(3000);
    }

    @Step("Entering username as {0}")
    public void EnterUserName(String username)
    {
        homepage.enterusername();
    }

    @Step("Entering password as {0}")
    public void EnterPasword(String password)
    {
homepage.enteruserpw();
    }

    @Step("Clicking Login Button")
    public void ClickLoginButton()
    {
homepage.clickLogin();
    }

}
