package pages;

import net.serenitybdd.annotations.DefaultUrl;
import pages.wrappers.PageObjectWrapper;
import utils.TestUtils;
import org.junit.Assert;

@DefaultUrl("dashboard/index")
public class DashboardPage extends PageObjectWrapper {
    public void Loginverify() {
        Assert.assertTrue("User is not logged in", verifyURLContains("dashboard"));
        TestUtils.addDelay(3000);
    }
}
