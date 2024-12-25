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

}
