package pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestUtils;

import java.time.Duration;

public class EmployeePage extends PageObject {

    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']")
    private WebElement pimMenuItem;

    @FindBy(name = "firstName")
    private WebElement firstname;

    @FindBy(name = "middleName")
    private WebElement middleName;

    @FindBy(name = "lastName")
    private WebElement lastname;

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElement saveButton;

    @FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab']//a[text()='Add Employee']")
    private WebElement AddEmployeeButton;

    @FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab']//a[text()='Employee List']")
    private WebElement employeeListTab;

    @FindBy(xpath = "//label[text()='Employee Name']/ancestor::div[contains(@class, 'oxd-input-group')]//input[@placeholder='Type for hints...']")
    private WebElement employeeNameInputField;

    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div[contains(text(), 'Yukthi Hettiarachchi')]")
    private WebElement searchResult;

    @FindBy(xpath = "//h6[text()='Yukthi Hettiarachchi']")
    private WebElement nameHeader;

    private WebDriverWait wait;

    public EmployeePage() {
        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));


    }

    public void navigateToAddEmployee()
    {
        pimMenuItem.click();
//        AddEmployeeButton.click();
        wait.until(ExpectedConditions.visibilityOf(AddEmployeeButton)).click();
    }

    public void enterEmployeeDetails(String firstName, String lastName)
    {
    firstname.sendKeys(firstName);
    lastname.sendKeys(lastName);

    }

    public void saveEmployee() {

        saveButton.click();
//        TestUtils.addDelay(4000);

    }


    public void redirectToViewPersonalDetails() {
        boolean isRedirected = wait.until(ExpectedConditions.urlContains("pim/viewPersonalDetails/empNumber"));

        if (!isRedirected) {
            throw new AssertionError("Page did not redirect to the expected URL after saving the employee.");
        }

    }
    public void verifyEmployeeDetails(String employeeName) {

        WebElement header = wait.until(ExpectedConditions.visibilityOf(nameHeader));
        String displayedName = header.getText();

        System.out.println("Displayed Employee Name: " + displayedName);

        if (!displayedName.equals(employeeName)) {
            throw new AssertionError("Displayed name does not match the expected name. Expected: "
                    + employeeName + ", but found: " + displayedName);
        }
    }



}
