package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestUtils;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import java.time.Instant;

public class DashBoardPage extends PageObject {




    private WebDriverWait wait;


    public void Loginverify()
    {

        String currentURL = (getDriver().getCurrentUrl());
        System.out.println(currentURL);
        assert currentURL != null;
        Assert.assertTrue(currentURL.contains("dashboard"));
        TestUtils.addDelay(4000);
    }





}
