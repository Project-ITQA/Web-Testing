package steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import pages.DashboardPage;
import utils.PagePaths;

public class DashboardSteps {

    DashboardPage dashboardPage;

    @Step("verify is on dashboard page")
    public void verifyIsOnDashboardPage() {
        Assert.assertTrue(dashboardPage.verifyPagePath(PagePaths.DASHBOARD));
    }
}
