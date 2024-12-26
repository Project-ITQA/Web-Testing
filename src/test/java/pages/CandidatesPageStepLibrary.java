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

    @Step
    public void typeIntoSearchBox(String text) {
        candidatesPage.typeIntoSearchBox(text);
    }

    @Step
    public void verifySearchDropDownItemExists(String firstName, String lastName) {
        candidatesPage.verifySearchDropDownItemExists(firstName, lastName);
    }

    @Step
    public void clickDropDownItem(String firstName, String lastName) {
        candidatesPage.clickDropDownItem(firstName, lastName);
    }

    @Step
    public void clickSearchButton() {
        candidatesPage.clickSearchButton();
    }

    @Step
    public void verifyOnlyOneRowExists(String firstName, String lastName) {
        candidatesPage.verifyOnlyOneRowExists(firstName, lastName);
    }
}
