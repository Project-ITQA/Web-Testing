package pages;

import utils.TestUtils;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

public class DashBoardPage extends PageObject {


    public void Loginverify()
    {

        String currentURL = (getDriver().getCurrentUrl());
        System.out.println(currentURL);
        assert currentURL != null;
        Assert.assertTrue(currentURL.contains("dashboard"));
        TestUtils.addDelay(1000);
    }
}
