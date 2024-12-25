package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.ui.Button;
import org.junit.Assert;
import utils.TestUtils;

import static java.util.concurrent.TimeUnit.SECONDS;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates")
public class OrangeHrmCandidatesPage extends PageObject {

    private WebElementFacade getCandidateRow(String firstName, String lastName) {
        for (WebElementFacade row : findAll(By.cssSelector(".oxd-table-row"))) {
            if(row.getText().toLowerCase().contains(firstName.toLowerCase()) && row.getText().toLowerCase().contains(lastName.toLowerCase())) {
                return row;
            }
        }
        return null;
    }

    private WebElementFacade getCandidateDeleteButton(String firstName, String lastName) {
        WebElementFacade row = getCandidateRow(firstName, lastName);
        if(row != null) {
            return row.find(By.cssSelector("button i.bi-trash"));
        }
        return null;
    }

    public void clickAddCandidateButton(){
        $(Button.withText("Add")).click();
    }

    public void verifyCandidateRow(String firstName, String lastName) {
        TestUtils.addDelay(3000);
        WebElementFacade row = getCandidateRow(firstName, lastName);
        Assert.assertNotNull(row);
    }

    public void clickDeleteButton(String firstName, String lastName) {
        WebElementFacade deleteButton = getCandidateDeleteButton(firstName, lastName);
        if(deleteButton != null) {
            deleteButton.click();
        }else{
            Assert.fail("Could not find delete button");
        }
    }

    public void clickConfirmDeleteButton() {
        TestUtils.addDelay(3000);
        withTimeoutOf(5, SECONDS).waitForPresenceOf(By.cssSelector(".oxd-button--label-danger")).click();
    }

    public void verifyNotCandidateRow(String firstName, String lastName) {
        WebElementFacade row = getCandidateRow(firstName, lastName);
        Assert.assertNull(row);
    }
}
