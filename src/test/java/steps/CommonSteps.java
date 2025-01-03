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

    @Step("verify if a toast pops up with message {0}")
    public void verifyToastPopUpWithMessage(String message) {
        Assert.assertTrue("toast message was not" + message, basePage.getToastMessage().equalsIgnoreCase(message));
    }

    @Step("click on the button having label {0}")
    public void clickOnButtonHavingLabel(String label) {
        basePage.clickButtonWithLabel(label);
    }

    @Step("check if there's any input validations errors")
    public void checkIfThereIsAnyInputValidationsErrors() {
        Assert.assertNotEquals("There are no input validation errors shown", 0,
                basePage.getInputValidationErrors().size()
        );
    }

    @Step("check if a record is available with value {0}")
    public void checkIfTheRecordIsAvailable(String value) {
        Assert.assertNotEquals("Record with value " + value + " is not on the table", 0,
                basePage.getValueOccurencesCountInTable(value)
        );
    }

    @Step("check if no records is available with value {0}")
    public void checkIfNoRecordsAvailableWith(String value) {
        Assert.assertEquals("Record with value" + value + " is available on the table", 0,
                basePage.getValueOccurencesCountInTable(value)
        );
    }

    @Step("check if a prompt is visible with message {0}")
    public void checkIfAPromptWithMessageIsVisible(String message) {
        Assert.assertTrue("prompt with the " + message + " is not visible",
                basePage.checkIfAPromptIsShowingWithMessage(message)
        );
    }
}
