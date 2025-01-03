package steps;

import net.serenitybdd.annotations.Step;
import pages.OrangeHrmBuzzPage;

public class BuzzSteps {
    OrangeHrmBuzzPage buzzPage;

    @Step
    public void openBuzzPage() {
        buzzPage.open();
    }

    @Step
    public void typeIntoPost(String content){
        buzzPage.typeIntoPost(content);
    }

    @Step
    public void clickPostButton(){
        buzzPage.clickPostButton();
    }

    @Step
    public void verifyPostAvailable(String content){
        buzzPage.verifyPostExistence(content);
    }

    @Step
    public void clickCommentButton(String content){
        buzzPage.clickCommentButton(content);
    }

    @Step
    public void typeComment(String content, String comment){
        buzzPage.typeComment(content,comment);
    }

    @Step
    public void verifyCommentAvailable(String content, String comment){
        buzzPage.verifyCommentExistence(content,comment);
    }

    @Step
    public void clickOptionsButton(String content){
        buzzPage.clickOptionsButton(content);
    }

    @Step
    public void clickDeleteButton(){
        buzzPage.clickDeleteButton();
    }

    @Step
    public void clickConfirmDeleteButton(){
        buzzPage.confirmDelete();
    }

    @Step
    public void verifyPostisDeleted(String content){
        buzzPage.verifyPostIsDeleted(content);
    }
}
