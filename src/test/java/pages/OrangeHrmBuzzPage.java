package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz")
public class OrangeHrmBuzzPage extends PageObjectBase {
    @FindBy(xpath = "//textarea[contains(@class, 'oxd-buzz-post-input')]")
    private WebElementFacade buzzPostInput;

    @FindBy(xpath = "//button[@type='submit' and contains(@class, 'oxd-button--main')]")
    private WebElementFacade postButton;

    public void typeIntoPost(String content){
        buzzPostInput.sendKeys(content);
    }

    public void clickPostButton(){
        postButton.waitUntilEnabled();
        postButton.click();
    }

    public void verifyPostExistence(String content) {
        try {
            WebElementFacade post = find(By.xpath("//p[contains(@class, 'orangehrm-buzz-post-body-text') and text()='" + content + "']"));
            post.waitUntilVisible();
            Assert.assertTrue("The post with the content '" + content + "' is not visible.", post.isDisplayed());
        } catch (TimeoutException e) {
            Assert.fail("Could not find the post with the content '" + content + "' within the timeout period.");
        } catch (Exception e) {
            Assert.fail("An unexpected error occurred while verifying the post existence: " + e.getMessage());
        }
    }

    public void clickCommentButton(String content){
        try {
            WebElementFacade postCommentButton = find(By.xpath("//p[contains(@class, 'orangehrm-buzz-post-body-text') and text()='" + content + "']/ancestor::div[contains(@class,'oxd-grid-item')]/descendant::i[contains(@class, 'bi-chat-text-fill')]/parent::button"));
            postCommentButton.waitUntilVisible();
            postCommentButton.click();
        } catch (TimeoutException e) {
            Assert.fail("Could not find the post with the content '" + content + "' within the timeout period.");
        } catch (Exception e) {
            Assert.fail("An unexpected error occurred while verifying the post existence: " + e.getMessage());
        }
    }

    public  void typeComment(String content,String comment){
        WebElementFacade postCommentInput = find(By.xpath("//p[contains(@class, 'orangehrm-buzz-post-body-text') and text()='" + content + "']/ancestor::div[contains(@class,'oxd-grid-item')]/descendant::div[contains(@class, 'oxd-input-group')]/descendant::input"));
        postCommentInput.waitUntilVisible();
        postCommentInput.sendKeys(comment);
        postCommentInput.sendKeys(Keys.ENTER);
    }

    public void  verifyCommentExistence(String content,String comment){
        try{
            WebElementFacade postComment = find(By.xpath("//p[contains(@class, 'orangehrm-buzz-post-body-text') and text()='" + content + "']/ancestor::div[contains(@class,'oxd-grid-item')]/descendant::span[contains(@class, 'orangehrm-post-comment-text') and text()= '" + comment + "']"));
            postComment.waitUntilVisible();
            Assert.assertTrue("The post with the content '" + content + "' is has comment.", postComment.isDisplayed());
        }catch (TimeoutException e) {
            Assert.fail("Could not find the comment");
        }
    }

    public void clickOptionsButton(String content){
        try{
            WebElementFacade optionsButton = find(By.xpath("//p[contains(@class, 'orangehrm-buzz-post-body-text') and text()='" + content + "']/ancestor::div[contains(@class,'oxd-grid-item')]/descendant::i[contains(@class, 'bi-three-dots')]/parent::button"));
            optionsButton.waitUntilVisible();
            optionsButton.click();
        }catch (TimeoutException e) {
            Assert.fail("Could not find the post");
        }
    }

    public void clickDeleteButton(){
        try{
            WebElementFacade deleteButton =find(By.xpath("//i[contains(@class, 'bi-trash')]/parent::*"));
            deleteButton.waitUntilVisible();
            deleteButton.click();
        }catch(TimeoutException e){
            Assert.fail("Could not find the delete button");
        }
    }

    public void confirmDelete(){
        try{
            WebElementFacade confirmDeleteButton = find(By.xpath("//button[contains(@class, 'oxd-button--label-danger')]"));
            confirmDeleteButton.waitUntilVisible();
            confirmDeleteButton.click();
        }
        catch(TimeoutException e){
            Assert.fail("Could not find the confirm delete button");
        }
    }

    public void verifyPostIsDeleted(String content) {
        boolean isPostPresent = find(By.xpath("//p[contains(@class, 'orangehrm-buzz-post-body-text') and text()='" + content + "']")).isPresent();
        Assert.assertFalse("The post with the content '" + content + "' is still visible.", isPostPresent);
    }


}
