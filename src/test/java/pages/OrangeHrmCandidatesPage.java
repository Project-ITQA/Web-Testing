package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.ui.Button;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import utils.TestUtils;

import java.util.List;

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

    public void typeIntoSearchBox(String text) {
        WebElementFacade searchBox = find(By.xpath("//div[contains(@class,'oxd-input-group') and .//label[text()='Candidate Name']]//input"));
        searchBox.sendKeys(text);
    }

    public void verifySearchDropDownItemExists(String firstName, String lastName) {
        WebElement dropDownItem;
        try{
            dropDownItem = withTimeoutOf(5, SECONDS).waitForPresenceOf(By.xpath("//div[contains(@class, 'oxd-autocomplete-option') and contains(text(), '"+ firstName + "') and contains(text(), '" + lastName + "')]"));
            Assert.assertNotNull(dropDownItem);
        } catch (Exception e) {
            Assert.fail("Could not find search drop down item");
        }
    }

    public void clickDropDownItem(String firstName, String lastName) {
        WebElement dropDownItem = withTimeoutOf(5, SECONDS).waitForPresenceOf(By.xpath("//div[contains(@class, 'oxd-autocomplete-option') and contains(text(), '"+ firstName + "') and contains(text(), '" + lastName + "')]"));
        dropDownItem.click();
    }

    public void clickSearchButton(){
        WebElementFacade searchButton = find(By.xpath("//button[contains(text(), 'Search')]"));
        searchButton.click();
    }

    public void verifyOnlyOneRowExists(String firstName, String lastName) {
        List<WebElementFacade> rows = findAll(By.cssSelector(".oxd-table-row"));
        Assert.assertEquals("Expected exactly one visible row, but found " + rows.size(), 1, rows.size());
        String rowText = rows.getFirst().getText().toLowerCase();
        Assert.assertTrue(rowText.contains(firstName.toLowerCase()) && rowText.contains(lastName.toLowerCase()));
    }
}
