package steps;

import net.serenitybdd.annotations.Step;
import pages.OrangeHrmAddCandidatePage;

public class AddCandidatesPageStepLibrary {
    OrangeHrmAddCandidatePage addCandidatePage;

    @Step
    public void openAddCandidatePage() {
        addCandidatePage.open();
    }

    @Step
    public void fillFirstName(String firstName) {
        addCandidatePage.fillFirstName(firstName);
    }

    @Step
    public void fillLastName(String lastName) {
        addCandidatePage.fillLastName(lastName);
    }

    @Step
    public void fillEmail(String email) {
        addCandidatePage.fillEmail(email);
    }

    @Step
    public void verifyAddCandidatePage() {
        addCandidatePage.verifyCurrentPage();
    }

    @Step
    public void clickSubmit() {
        addCandidatePage.clickSubmitButton();
    }

    @Step
    public void verifyEmailRequiredMessage(){
        addCandidatePage.verifyEmailRequiredMessage();
    }
}
