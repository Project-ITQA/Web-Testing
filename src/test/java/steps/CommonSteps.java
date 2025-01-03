package steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import pages.PageObjectBase;
import utils.TestUtils;

public class CommonSteps {
    PageObjectBase basePage;

    @Step("fill input fields having labels with values - {0}")
    public void fillInputFieldsHavingLabels(String valuePairs) {
        String[] pairs = valuePairs.split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            basePage.fillInputFieldHavingLabel(key, value);
            TestUtils.addDelay(1000);
        }
    }

    @Step("select options with matching values in dropdown fields with labels - {0}")
    public void selectDropdownOptionsWithLabels(String valuePairs) {
        String[] pairs = valuePairs.split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            basePage.selectOptionFromDropDownHavingLabel(key, value);
            TestUtils.addDelay(1000);
        }
    }

    @Step("check if a toast pops up with message {0}")
    public void checkToastPopUpWithMessage(String message) {
        Assert.assertTrue("toast message was not" + message, basePage.getToastMessage().equalsIgnoreCase(message));
    }

    @Step("click on the button having label {0}")
    public void clickOnButtonHavingLabel(String label) {
        basePage.clickButtonWithLabel(label);
    }
}
