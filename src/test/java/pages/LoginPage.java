package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import utils.PagePaths;


@DefaultUrl(PagePaths.LOGIN)
public class LoginPage extends PageObjectBase {
    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button--main')]")
    private WebElementFacade loginButton;


    public void enterusername() {
        username.sendKeys("Admin");
    }

    public void enteruserpw() {
        password.sendKeys("admin123");
    }

    public void clickLogin() {
        loginButton.click();
    }
}
