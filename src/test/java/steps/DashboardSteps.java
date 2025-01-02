package steps;

import net.serenitybdd.annotations.Step;
import pages.DashboardPage;

public class DashboardSteps {

DashboardPage dashboardPage;

    @Step("Verifying admin login")
    public void VerifyAdminLogin()
    {
        dashboardPage.Loginverify();
    }
}
