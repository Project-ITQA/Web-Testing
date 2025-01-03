package steps;

import net.serenitybdd.annotations.Step;
import pages.OrangeHrmCandidateViewPage;

public class ViewCandidatePageStepLibrary {
    OrangeHrmCandidateViewPage hrmCandidateViewPage;

    @Step
    public void verifyCurrentPage(){hrmCandidateViewPage.verifyCurrentPage();}

    @Step
    public void checkForCandidateName(String firstName, String lastName){
        hrmCandidateViewPage.verifyNameInField(firstName, lastName);
    }
}
