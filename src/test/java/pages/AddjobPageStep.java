package pages;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

public class AddjobPageStep extends PageObject {

    OrangeHrmAddjobPage addjobPage;

    @Step
    public void verifyAddJobPage() {
        String currentURL = getDriver().getCurrentUrl();
        Assert.assertTrue(currentURL.contains("saveJobTitle"));
    }

    @Step
    public void fillJobTitle(String jobTitle) {

        addjobPage.fillJobTitle(jobTitle);
    }

    @Step
    public void clickSubmit() {

        addjobPage.clickSaveButton();
    }

}
