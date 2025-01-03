package steps;

import net.serenitybdd.annotations.Step;
import pages.UserPageAdd;

public class UserPageAddStepLibrary {
    UserPageAdd userPageAdd;

    @Step("Filling user role as {0}")
    public void fillUserRole(String userRole) {
       userPageAdd.fillUserRole(userRole);
    }

    @Step("Filling employee name as {0}")
    public void fillEmployeeName(String employeeName) {
        userPageAdd.fillEmployeeName(employeeName);
    }

    @Step("Filling status name as {0}")
    public void fillStatus(String status) {
        userPageAdd.fillStatus(status);
    }

    @Step("Filling username name as {0}")
    public void fillUsername(String username) {
        userPageAdd.fillUsername(username);
    }

    @Step("Filling password as {0}")
    public void fillPassword(String password) {
        userPageAdd.fillPassword(password);
    }

    @Step("Filling confirm password as {0}")
    public void fillConfirmPassword(String confirmPassword) {
        userPageAdd.fillConfirmPassword(confirmPassword);
    }

    @Step("Verify current page")
    public void verifyCurrentPage()
    {
        userPageAdd.verifyCurrentPage();
    }

    @Step("Click submit button")
    public void clickSubmitButton() {
        userPageAdd.clickSubmitButton();
    }

    @Step
    public void verifyRequiredMessage(){
        userPageAdd.verifyRequiredMessage();
    }

    @Step
    public void verifyPasswordDoNotMatchMessage(){
        userPageAdd.verifyPasswordDoNotMatchMessage();
    }
}
