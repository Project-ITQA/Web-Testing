package pages;

import utils.TestUtils;
import net.serenitybdd.annotations.Step;

public class LoginSteps {

LoginPage homepage;

    @Step
    public void OpenAppication()
    {
        homepage.open();
        TestUtils.addDelay(1000);
    }

    @Step
    public void EnterUserName(String username)
    {

        homepage.enterusername(username);
    }

    @Step
    public void EnterPasword(String password)
    {
homepage.enteruserpw(password);
    }

    @Step
    public void ClickLoginButton()
    {
homepage.clickLogin();
    }

}
