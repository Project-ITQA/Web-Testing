package pages;

import net.serenitybdd.annotations.Step;

public class AuthenticatedBaseTest  {

    LoginPage LoginPage;

    @Step
    public void loginAsAdmin() {
        LoginPage.open();
        LoginPage.enterusername("Admin");
        LoginPage.enteruserpw("admin123");
        LoginPage.clickLogin();
    }
}
