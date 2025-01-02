package pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import utils.TestUtils;

import java.util.List;

public class OrangeHrmViewClaimPage extends PageObject {

    @FindBy(xpath = "//label[text()='Event']/following::input[@class='oxd-input oxd-input--active' and @disabled]")
     private WebElementFacade eventField;

    @FindBy(xpath = "//label[text()='Currency']/following::input[@class='oxd-input oxd-input--active' and @disabled]")
    private WebElementFacade currencyField;

    @FindBy(xpath = "//label[text()='Reference Id']/following::input[@class='oxd-input oxd-input--active' and @disabled]")
    private WebElementFacade referenceIdField;

    @FindBy(xpath = "//label[text()='Remarks']/following::textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical' and @disabled]")
    private WebElementFacade remarksField;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button') and contains(., 'Add')]")
    private WebElementFacade addButton;

    @FindBy(xpath = "//div[contains(@class, 'oxd-dialog-sheet') and @role='document']")
    private WebElementFacade addExpenseModal;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button') and contains(., 'Save')]")
    private WebElementFacade SaveButton;

    @FindBy(xpath = "//label[text()='Status']/following::input[@class='oxd-input oxd-input--active' and @disabled]")
    private WebElementFacade statusField;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button') and contains(., 'Submit')]")
    private WebElementFacade submitButton;

    public void verifyViewClaimPage(){
        //Get the referenceId
        String referenceId = referenceIdField.getDomProperty("_value");
        //Set the referenceId in the session
        Serenity.setSessionVariable("referenceId").to(referenceId);

        String currentURL = getDriver().getCurrentUrl();
        Assert.assertTrue(currentURL.contains("id"));
    }

    public void verifyClaimDetails(String event, String currency, String remarks){
        Assert.assertEquals(event, eventField.getDomProperty("_value"));
        Assert.assertEquals(currency, currencyField.getDomProperty("_value"));
        Assert.assertEquals(remarks, remarksField.getDomProperty("_value"));
    }

    public void clickAddButton(){
        addButton.click();
    }

    public void verifyAddExpenseModal(){
        Assert.assertTrue(addExpenseModal.isDisplayed());
    }

    public void selectExpenseType(String expenseType){
        WebElementFacade expenseTypeDropDown = find(By.xpath("//label[text()='Expense Type']/following::div[@class='oxd-select-text oxd-select-text--active'][1]"));
        expenseTypeDropDown.click();
        WebElementFacade expenseTypeDropDownOptions = find(By.xpath("//label[text()='Expense Type']/following::div[@role='listbox'][1]"));
        expenseTypeDropDownOptions.waitUntilVisible();
        WebElementFacade expenseTypeDropDownOption = find(By.xpath("//label[text()='Expense Type']/following::div[@role='listbox']//div[@role='option']//span[text()='" + expenseType + "']"));
        if (expenseTypeDropDownOption == null){
            Assert.fail("Expense Type not found: " + expenseType);
        }
        expenseTypeDropDownOption.click();
    }

    public void enterExpenseAmount(String amount){
        WebElementFacade amountField = find(By.xpath("//label[text()='Amount']/following::input[@class='oxd-input oxd-input--active']"));
        amountField.type(amount);
    }

    public void enterExpenseDate(String date){
        WebElementFacade dateField = find(By.xpath("//label[text()='Date']/following::input[@class='oxd-input oxd-input--active']"));
        dateField.type(date);
    }

    public void enterExpenseNote(String note){
        WebElementFacade noteField = find(By.xpath("//label[text()='Note']/following::textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']"));
        noteField.type(note);
    }

    public void clickSaveButton(){
        SaveButton.click();
        TestUtils.addDelay(3000);
    }

    public void verifyExpenseDetails(String expenseType, String amount, String date, String note){
        //Get the rows
        List<WebElementFacade> rows = findAll(By.xpath("//div[@class='oxd-table-body']//div[@role='row']"));
        //Check if any row matches the expense details
        for (WebElementFacade row : rows) {
            String rowText = row.getText().toLowerCase();
            if (rowText.contains(expenseType.toLowerCase()) && rowText.contains(amount.toLowerCase()) && rowText.contains(date.toLowerCase()) && rowText.contains(note.toLowerCase())) {
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.fail("No matching expense details found");
    }

    public void clickSubmitButton(){
        submitButton.click();
        TestUtils.addDelay(3000);
    }

    public void verifyClaimStatus(String status){
        //Wait for the status to be updated
        TestUtils.addDelay(5000);
        Assert.assertEquals(status, statusField.getDomProperty("_value"));
    }
}
