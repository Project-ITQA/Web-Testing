package steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import pages.MyInfoPage;
import utils.PagePaths;

import java.util.Objects;

public class MyInfoSteps {
    MyInfoPage myInfoPage;

    @Step("verify is on my info page")
    public void verifyOnMyInfoPage() {
        Assert.assertTrue("user is not on my info page", myInfoPage.verifyPagePath(PagePaths.MY_INFO));
    }

    @Step("navigate to section {0}")
    public void navigateToSection(String section) {
        myInfoPage.clickSectionItem(section);
    }

    @Step("verify on {0} section")
    public void verifyOnSection(String section) {
        Assert.assertTrue("user is not in section" + section, myInfoPage.verifySection(section));
    }

    @Step("clicks on {1} button in the {0} space")
    public void clickTheButtonInTheSpace(String spaceTitle, String buttonLabel) {
        myInfoPage.clickTheButtonInTheSpace(spaceTitle, buttonLabel);
    }

    @Step("clicks on {0} icon button")
    public void clickOnIconButton(String buttonType, String value) {
        if (Objects.equals(buttonType, "Delete")){
            myInfoPage.clickOnDeleteIconButtonInRowWithValue(value);
        }
    }
}
