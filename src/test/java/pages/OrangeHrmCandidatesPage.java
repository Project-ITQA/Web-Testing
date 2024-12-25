package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.ui.Button;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates")
public class OrangeHrmCandidatesPage extends PageObject {

    public void clickAddCandidateButton(){
        $(Button.withText("Add")).click();
    }
}
