package pages;

import net.serenitybdd.annotations.Step;

public class AuthenticatedBaseTest  {

    LoginPage LoginPage;

    @Step
    public void loginAsAdmin() {
        LoginPage.open();
        LoginPage.enterusername();
        LoginPage.enteruserpw();
        LoginPage.clickLogin();
    }
}
