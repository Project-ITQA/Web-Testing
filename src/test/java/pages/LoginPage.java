package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import utils.PagePaths;


@DefaultUrl(PagePaths.LOGIN)
public class LoginPage extends PageObjectBase {
    @FindBy(name = "username")
    private WebElementFacade username;

    @FindBy(name = "password")
    private WebElementFacade password;

    @FindBy(xpath = "//button[contains(@class, 'oxd-button--main')]")
    private WebElementFacade loginButton;


    public void enterusername(String usernamevalue) {
        username.sendKeys(usernamevalue);
    }

    public void enteruserpw(String passwordvalue) {
        password.sendKeys(passwordvalue);
    }

    public void clickLogin() {
        loginButton.click();
    }
}
