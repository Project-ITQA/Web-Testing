package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import utils.TestUtils;

import java.util.List;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/claim/viewAssignClaim")
public class OrangeHrmClaimsPage extends PageObject {

    @FindBy(xpath = "//li[contains(@class, 'oxd-topbar-body-nav-tab')]//a[text()='Submit Claim']" )
    private WebElementFacade submitClaimButton;

    @FindBy(xpath = "//button[@type='submit' and text()=' Search ']")
    private WebElementFacade searchButton;

    public void clickSubmitClaimButton(){
        submitClaimButton.click();
    }

    //Get the dropdown
    private WebElementFacade getDropDown(String dropDownName) {
        return find(By.xpath("//label[text()='" + dropDownName + "']/following::div[@class='oxd-select-text oxd-select-text--active'][1]"));
    }

    //Get the dropdown options
    private WebElementFacade getDropDownOptions(String dropDownName) {
        return find(By.xpath("//label[text()='" + dropDownName + "']/following::div[@role='listbox'][1]"));
    }

    //Select the dropdown option
    public void selectDropDownOption(String dropDownName, String option) {
        WebElementFacade dropDown = getDropDown(dropDownName);
        dropDown.click();
        WebElementFacade dropDownOptions = getDropDownOptions(dropDownName);
        dropDownOptions.waitUntilVisible();
        WebElementFacade dropDownOption = find(By.xpath("//label[text()='" + dropDownName + "']/following::div[@role='listbox']//div[@role='option']//span[text()='" + option + "']"));
        if (dropDownOption == null){
            Assert.fail("Event not found: " + option);
        }
        dropDownOption.waitUntilVisible().click();
    }

    //Select ReferenceId
    public void selectReferenceId() {

        String referenceId = Serenity.sessionVariableCalled("referenceId");

        WebElementFacade referenceInput = find(By.xpath("//label[text()='Reference Id']/following::input[@placeholder='Type for hints...']"));
        referenceInput.type(referenceId);

        WebElementFacade referenceOptions = getDropDownOptions("Reference Id");
        referenceOptions.waitUntilVisible();

        WebElementFacade referenceOption = find(By.xpath("//label[text()='Reference Id']/following::div[@role='listbox']//div[@role='option']//span[text()='" + referenceId + "']"));
        if (referenceOption == null){
            Assert.fail("Reference Id not found: " + referenceId);
        }

        referenceOption.waitUntilVisible().click();
    }

    public void clickSearchButton(){
        searchButton.click();
        TestUtils.addDelay(3000);
    }

    public void verifyOnlyOneRowExists(String event, String currency, String remarks) {
        //Get the rows
        List<WebElementFacade> rows = findAll(By.xpath("//div[@class='oxd-table-body']//div[@role='row']"));
        //Check if only one row exists
        if(rows.isEmpty()){
            Assert.fail("No rows found");
        }
        else if ( rows.size() > 1){
            Assert.fail("Expected exactly one row, but found " + rows.size());

        }
        //Get the row text
        String rowText = rows.getFirst().getText().toLowerCase();
        //Check if the row text contains the event, currency and remarks
        Assert.assertTrue(rowText.contains(event.toLowerCase()) && rowText.contains(currency.toLowerCase()) && rowText.contains(remarks.toLowerCase()));
    }
}
