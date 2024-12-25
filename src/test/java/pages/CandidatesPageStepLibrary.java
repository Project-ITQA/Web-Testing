package pages;

import net.serenitybdd.annotations.Step;

public class CandidatesPageStepLibrary {
    OrangeHrmCandidatesPage candidatesPage;

    @Step
    public void openCandidatesPage() {
        candidatesPage.open();
    }

    @Step
    public void clickAddCandidateButton() {
        candidatesPage.clickAddCandidateButton();
    }

    @Step
    public void verifyCandidateRowAvailability(String firstName, String lastName) {
        candidatesPage.verifyCandidateRow(firstName, lastName);
    }

    @Step
    public void clickDeleteButton(String firstName, String lastName) {
        candidatesPage.clickDeleteButton(firstName, lastName);
    }

    @Step
    public void clickConfirmDeleteButton() {
        candidatesPage.clickConfirmDeleteButton();
    }

    @Step
    public void verifyCandidateRowNonAvailability(String firstName, String lastName) {
        candidatesPage.verifyNotCandidateRow(firstName, lastName);
    }
}
