package pages;

import net.serenitybdd.annotations.Step;

public class EditJobPageStep {

    OrangeHrmEditJobPage editJobPage;

    @Step
    public void verifyEditJobPage() {
        editJobPage.verifyEditJobPage();
    }

    @Step
    public void fillEditJobTitle(String title) {
        editJobPage .fillJobTitle(title);
    }

    @Step
    public void clickSubmit() {
        editJobPage.clickSaveButton();
    }
}
