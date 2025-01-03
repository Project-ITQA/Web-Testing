package pages;

import groovy.lang.GString;
import jxl.common.AssertionFailed;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.TestUtils;

import java.time.Duration;

public class EmployeePage extends PageObject {

    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']")
    private WebElementFacade pimMenuItem;

    @FindBy(name = "firstName")
    private WebElementFacade firstname;

    @FindBy(name = "middleName")
    private WebElementFacade middleName;

    @FindBy(name = "lastName")
    private WebElementFacade lastname;

    @FindBy(xpath = "//button[text()=' Save ']")
    private WebElementFacade saveButton;

    @FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab']//a[text()='Add Employee']")
    private WebElementFacade AddEmployeeButton;

    @FindBy(xpath = "//li[@class='oxd-topbar-body-nav-tab']//a[text()='Employee List']")
    private WebElementFacade employeeListTab;

    @FindBy(xpath = "//label[text()='Employee Name']/ancestor::div[contains(@class, 'oxd-input-group')]//input[@placeholder='Type for hints...']")
    private WebElementFacade employeeNameInputField;

    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElementFacade searchButton;

    @FindBy(xpath = "//div[@class='oxd-table-body']//div[contains(text(), 'Yukthi Hettiarachchi')]")
    private WebElementFacade searchResult;

//    @FindBy(xpath = "//h6[text()='Yukthi Hettiarachchi']")

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/h6")
    private WebElementFacade nameHeader;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]")
    private WebElementFacade profHeader;


    @FindBy(xpath = "//input[@type='checkbox' and @wfd-id='id6']")
    private WebElementFacade createLoginToggle;

    @FindBy(xpath = "//div[@class='oxd-switch-wrapper']//input[@type='checkbox']")
    private WebElementFacade checkbox;

//    @FindBy(xpath = "//label[input[@wfd-id='id6']]")

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")
    private WebElementFacade checkboxLabel;



    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")
    private WebElementFacade usernameField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input")
    private WebElementFacade passwordField;

    @FindBy(xpath = "    //*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
    private WebElementFacade EmpIDField;


    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")
    private WebElementFacade confirmPasswordField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[1]/div[2]/div/label")
    private WebElementFacade enabledRadioButton;

    @FindBy(css = "li.oxd-userdropdown")
    private WebElementFacade userDropdown;

    @FindBy(css = "a.oxd-userdropdown-link[href='/web/index.php/auth/logout']")
    private WebElementFacade logoutLink;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a")
    private WebElementFacade employeeList;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
    private WebElementFacade employeeserchbox;

    @FindBy(xpath = "    //*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
    private WebElementFacade employeeserchIDbox;

//    @FindBy(xpath = "//button[text()='Search']")
    @FindBy(xpath = "//*[contains(text(),'Rset')]")
    private WebElementFacade empserchbutton;


    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
    private WebElementFacade ResultfoundSpan;


    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span[contains(text(), 'Found')]")
    private WebElementFacade foundSpan;

    //*[@id="app"]/div[3]/div/div/div/div[1]/p
    @FindBy(xpath = "//p[contains(text(), 'Are you Sure?')]")
    private WebElementFacade popup;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    private WebElementFacade popupButton;

    @FindBy(xpath = "//button[contains(text(), ' Search ')]")
    private WebElementFacade empsearchButton2;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button--secondary') and contains(@class, 'orangehrm-left-space')]")
    private WebElementFacade searchButton3;
//
//    @FindBy(xpath = "//button[@type='submit' and contains(text(), ' Search ')]")
//    private WebElementFacade searchButtonwork;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    private WebElementFacade searchButtonwork;


    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[2]\n")
    private WebElementFacade deleteButtonwork;











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

//    public void enterEmployeeDetails(String firstName, String lastName, String empId)
//    {
//        EmpIDField.clear();
//    firstname.sendKeys(firstName);
//    lastname.sendKeys(lastName);
//    EmpIDField.sendKeys(empId);
//
//    }

    public void enterEmployeeDetails(String firstName, String lastName, String empId) {
        wait.until(ExpectedConditions.visibilityOf(EmpIDField));
        EmpIDField.click();
        EmpIDField.sendKeys(org.openqa.selenium.Keys.chord(org.openqa.selenium.Keys.CONTROL, "a"));
        EmpIDField.sendKeys(org.openqa.selenium.Keys.DELETE);

        firstname.sendKeys(firstName);
        lastname.sendKeys(lastName);
        EmpIDField.sendKeys(empId);
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

//    public void verifyEmployeeNotInList(String employeeName) {
//        pimMenuItem.click();
//        wait.until(ExpectedConditions.visibilityOf(employeeListTab)).click();
//
//        wait.until(ExpectedConditions.visibilityOf(employeeNameInputField)).sendKeys(employeeName);
//        searchButton.click();
//
//        boolean isDisplayed = searchResult.isDisplayed();
//        if (isDisplayed) {
//            throw new AssertionError("Invalid employee with name " + employeeName + " should not be listed.");
//        }
//    }

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

    public void userNavigateToEmployeeListTab() {
        employeeList.click();
    }

    public void verifyRedirectionToEmployeeListTab() {
        boolean isRedirected = wait.until(ExpectedConditions.urlContains("viewEmployeeList"));

        if (!isRedirected) {
            throw new AssertionError("Unexpected Not redirection to the employee list");
        }
    }

    public void searchEmployee(String searchText) {
        employeeserchbox.clear();

        employeeserchIDbox.sendKeys(searchText);
        TestUtils.addDelay(2000);
//        empserchbutton.click();
//        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButtonwork.click();
    }

//public void searchEmployee(String searchText) {
//    employeeserchIDbox.sendKeys(searchText);
//    wait.until(ExpectedConditions.visibilityOf(empserchbutton));
//    scrollIntoView(empserchbutton);
//    try {
//        wait.until(ExpectedConditions.elementToBeClickable(empserchbutton)).click();
//    } catch (Exception e) {
//        evaluateJavascript("arguments[0].click();", empserchbutton);
//    }
//}


    // Helper method to scroll into view
    private void scrollIntoView(WebElementFacade element) {
        evaluateJavascript("arguments[0].scrollIntoView(true);", element);
    }


    public void thereAreSearchResult()
    {
        wait.until(ExpectedConditions.visibilityOf(ResultfoundSpan));
        String displayedText = ResultfoundSpan.getText();

        System.out.println(displayedText);
        if (displayedText.contains("No Records Found")) {
            throw new AssertionError("Search result returned: 'No Record Found'. Expected records to be found.");
        }

    }

    //*[@id="app"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div
    //*[@id="app"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[9]/div/button[2]
    public void deleteRowByEmpID() {
//        try {
////            wait.until(ExpectedConditions.visibilityOf((WebElement) By.xpath("//div[@class='oxd-table-body']//div[contains(text(), '" + empID + "')]")));
////            WebElementFacade employeeRow = find(By.xpath("//div[@class='oxd-table-body']//div[contains(text(), '" + empID + "')]"));
////            WebElement deleteButton = employeeRow.then(By.xpath("./following-sibling::td//button[@class='delete-button']"));
////            deleteButton.click();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }


        wait.until(ExpectedConditions.visibilityOf(deleteButtonwork));
        deleteButtonwork.click();
//        TestUtils.addDelay(2000);
    }

    public void pressPopUp()
    {
//        wait.until(ExpectedConditions.visibilityOf(popup));

        popupButton.click();

    }

    public void userGetNoRecordsFoundOnTheTable(){
        wait.until(ExpectedConditions.visibilityOf(ResultfoundSpan));
        String displayedText = ResultfoundSpan.getText();

        System.out.println(displayedText);
        if (displayedText.contains("Records Found")) {
            throw new AssertionError("Search result returned: 'Some Records Found'. Expected records not to be found.");
        }
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
