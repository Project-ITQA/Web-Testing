package pages;

import utils.TestUtils;
import net.serenitybdd.annotations.Step;

public class Homepage {

OrangrHrmHomePage homepage;

    @Step
    public void OpenAppication()
    {
        homepage.open();
        TestUtils.addDelay(3000);
    }

    @Step
    public void EnterUserName(String username)
    {
homepage.enterusername();
    }

    @Step
    public void EnterPasword(String password)
    {
homepage.enteruserpw();
    }

    @Step
    public void ClickLoginButton()
    {
homepage.clickLogin();
    }

}
