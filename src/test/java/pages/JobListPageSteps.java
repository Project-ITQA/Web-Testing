package pages;

import net.serenitybdd.annotations.Step;
import utils.TestUtils;

public class JobListPageSteps {

    OrangeHrmJobListPage jobListPage;

    @Step
    public void openJobListPage() {
        jobListPage.open();
    }

    @Step
    public void clickAddJobButton() {
        jobListPage.clickAddJobButton();
    }

    @Step
    public void verifyJoblistPage() {
        jobListPage.verifyJobListPage();
    }

    @Step
    public void verifyJobTittleAdded(String jobTitle) {
        jobListPage.verifyJobTitle(jobTitle);
    }

    @Step
    public void verifyJobRowAvailability(String title) {
        jobListPage.verifyJobTitle(title);
    }

    @Step
    public void clickDeleteButton(String title) {
        jobListPage.clickDeleteButton(title);
    }

    @Step
    public void clickConfirmDeleteButton() {
        TestUtils.addDelay(3000);
        jobListPage.clickConfirmDeleteButton();
    }
    @Step
    public void clickEditButton(String title) {
        jobListPage.clickEditButton(title);
    }

    @Step
    public void verifyJobRowNonAvailability(String title) {
        jobListPage.verifyNotJobRow(title);
    }

}
