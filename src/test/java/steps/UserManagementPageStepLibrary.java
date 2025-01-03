package steps;

import net.serenitybdd.annotations.Step;
import pages.UserManagementPage;

public class UserManagementPageStepLibrary {
    UserManagementPage userManagementPage;

    @Step("Clicking user add button")
    public void clickUserAddButton(){
        userManagementPage.clickAddUserButton();
    }

    @Step("Navigating to user management page")
    public void openUserPage(){
        userManagementPage.open();
    }

    @Step("Verify current page")
    public void verifyCurrentPage(){
        userManagementPage.verifyCurrentPage();
    }

    @Step("Check user by username as {0}")
    public void checkUsername(String username){
         userManagementPage.checkUsername(username);
    }

    @Step
    public void typeIntoSearchBox(String text) {
        userManagementPage.typeIntoSearchBox(text);
    }
    @Step
    public void clickSearchButton() {
        userManagementPage.clickSearchButton();
    }
    @Step
    public void clickDeleteButton(String username) {
        userManagementPage.clickDeleteButton(username);
    }

    @Step
    public void clickConfirmDeleteButton() {
        userManagementPage.clickConfirmDeleteButton();
    }

    @Step
    public void checkUsernameNotAvailable(String username) {
        userManagementPage.checkUsernameNotAvailable(username);
    }

}
