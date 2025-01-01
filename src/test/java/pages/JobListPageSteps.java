package pages;

import net.serenitybdd.annotations.Step;

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

}
