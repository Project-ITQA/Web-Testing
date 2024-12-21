package pages;

import net.serenitybdd.annotations.Step;

public class Dashboard {

OrangrHrmDashboard orangrHrmDashboard;

    @Step
    public void VerifyAdminLogin()
    {
        orangrHrmDashboard.Loginverify();
    }
}
