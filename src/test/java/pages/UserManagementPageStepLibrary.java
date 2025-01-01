package pages;

import net.serenitybdd.annotations.Step;

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
}
