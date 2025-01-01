package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.junit.Assert;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/saveJobTitle")

public class OrangeHrmAddjobPage extends PageObject {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
    private WebElementFacade jobTitle;

    @FindBy (xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]")
    private WebElementFacade saveButton;

    public void fillJobTitle(String jobTitle) {
        this.jobTitle.sendKeys(jobTitle);
    }

    public void verifyCurrentPage()
    {
        String currentURL = (getDriver().getCurrentUrl());
        System.out.println(currentURL);
        assert currentURL != null;
        Assert.assertTrue(currentURL.contains("admin/saveJobTitle"));
    }

    public void clickSaveButton() {
        saveButton.click();
    }

}
