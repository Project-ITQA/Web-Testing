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

//    @FindBy(xpath = "//h6[text()='Yukthi Hettiarachchi']")

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6")
    private WebElement nameHeader;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]")
    private WebElement profHeader;


    @FindBy(xpath = "//input[@type='checkbox' and @wfd-id='id6']")
    private WebElement createLoginToggle;

    @FindBy(xpath = "//div[@class='oxd-switch-wrapper']//input[@type='checkbox']")
    private WebElement checkbox;

//    @FindBy(xpath = "//label[input[@wfd-id='id6']]")

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")
    private WebElement checkboxLabel;



    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[1]/div[2]/div/label")
    private WebElement enabledRadioButton;

    @FindBy(css = "li.oxd-userdropdown")
    private WebElement userDropdown;

    @FindBy(css = "a.oxd-userdropdown-link[href='/web/index.php/auth/logout']")
    private WebElement logoutLink;


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
        TestUtils.addDelay(4000);

        if (!isRedirected) {
            throw new AssertionError("Page did not redirect to the expected URL after saving the employee.");
        }

    }
    public void verifyEmployeeDetails(String employeeName) {

        wait.until(ExpectedConditions.visibilityOf(profHeader));
        String displayedName = nameHeader.getText();

        System.out.println("Displayed Employee Name: " + displayedName);

        if (!displayedName.equals(employeeName)) {
            throw new AssertionError("Displayed name does not match the expected name. Expected: "
                    + employeeName + ", but found: " + displayedName);
        }
    }


//    for invalid user names


    public void verifyNoRedirectionToPersonalDetails() {
        boolean isRedirected = wait.until(ExpectedConditions.urlContains("pim/viewPersonalDetails/empNumber"));

        if (isRedirected) {
            throw new AssertionError("Unexpected redirection to the employee personal details page with invalid employee details.");
        }
    }

    public void verifyEmployeeNotInList(String employeeName) {
        pimMenuItem.click();
        wait.until(ExpectedConditions.visibilityOf(employeeListTab)).click();

        wait.until(ExpectedConditions.visibilityOf(employeeNameInputField)).sendKeys(employeeName);
        searchButton.click();

        boolean isDisplayed = searchResult.isDisplayed();
        if (isDisplayed) {
            throw new AssertionError("Invalid employee with name " + employeeName + " should not be listed.");
        }
    }

// for checl login details for new user

        public void toggleCreateLoginDetails() {
            checkboxLabel.click();
        }

        public void enterLoginDetails(String username, String password) {
            wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
            passwordField.sendKeys(password);
            confirmPasswordField.sendKeys(password);
        }

    public void selectEnabledRadioButton() {
        if (!enabledRadioButton.isSelected()) {
            enabledRadioButton.click();
        }
    }


    public void logout() {
        userDropdown.click();
        logoutLink.click();

        wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    }


//        public void loginWithCredentials(String username, String password) {
//            wait.until(ExpectedConditions.visibilityOf(loginUsernameField)).sendKeys(username);
//            loginPasswordField.sendKeys(password);
//            loginButton.click();
//        }
//
//        public void verifySuccessfulLogin() {
//            boolean isDisplayed = wait.until(ExpectedConditions.visibilityOf(welcomeMessage)).isDisplayed();
//            if (!isDisplayed) {
//                throw new AssertionError("Login was not successful.");
//            }
//        }





}
