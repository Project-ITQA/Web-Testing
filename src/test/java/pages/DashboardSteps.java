package pages;

import net.serenitybdd.annotations.Step;

public class DashboardSteps {

DashBoardPage orangrHrmDashboard;

    @Step
    public void VerifyAdminLogin()
    {
        orangrHrmDashboard.Loginverify();
    }
}
