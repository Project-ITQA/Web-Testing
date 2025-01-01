package pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;

import static org.junit.Assert.assertTrue;

public class EmployeeSteps extends AuthenticatedBaseTest{

//    @Steps
    EmployeePage employeePage;

    @Step
    public void navigateToAddEmployeePage() {
        employeePage.navigateToAddEmployee();


    }

    @Step
    public void enterEmployeeDetails(String firstName, String lastName) {
        employeePage.enterEmployeeDetails(firstName, lastName);
    }

    @Step
    public void saveEmployee() {
        employeePage.saveEmployee();
    }

    @Step
    public void redirectToViewPersonalDetails() {
        employeePage.redirectToViewPersonalDetails();
    }

    @Step
    public void verifyEmployeeDetails(String employeeName) {
        employeePage.verifyEmployeeDetails(employeeName);
    }


    @Step
    public void verifyNoRedirectionToPersonalDetails() {
        employeePage.verifyNoRedirectionToPersonalDetails();
    }

//    @Step
//    public void verifyInvalidEmployeeNotInList(String employeeName) {
//        employeePage.verifyEmployeeNotInList(employeeName);
//    }

    @Step
    public void toggleCreateLoginDetails() {
        employeePage.toggleCreateLoginDetails();
    }

    @Step
    public void enterLoginDetails(String username, String password) {
        employeePage.enterLoginDetails(username, password);
    }
    @Step
    public void selectEnabledRadioButton() {
        employeePage.selectEnabledRadioButton();
    }

    @Step
    public void logout() {
        employeePage.logout();
    }

//    @Step
//    public void loginWithCredentials(String username, String password) {
//        employeePage.loginWithCredentials(username, password);
//    }
//
//    @Step
//    public void verifySuccessfulLogin() {
//        employeePage.verifySuccessfulLogin();
//    }


}
