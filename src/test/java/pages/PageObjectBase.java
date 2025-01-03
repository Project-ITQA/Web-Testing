package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;

import java.util.List;

public class PageObjectBase extends PageObject {

    public boolean verifyPagePath(String path) {
        String url = getDriver().getCurrentUrl();
        assert url != null;
        return url.contains(path.replaceAll("\\{[^}]*}", ""));
    }

    public void fillInputFieldHavingLabel(String label, String value) {
        WebElementFacade inputField = findBy("//label[normalize-space()='"+ label +"']/following::div//input");
        inputField.waitUntilVisible();
        inputField.click();
        inputField.sendKeys(Keys.CONTROL, "a");
        inputField.sendKeys(Keys.DELETE);
        inputField.sendKeys(value);
    }

    public void selectOptionFromDropDownHavingLabel(String label, String value) {
        WebElementFacade selectField = findBy("//label[normalize-space()='"+ label +"']/following::div[contains(@class, 'oxd-select-wrapper')]//div[@class='oxd-select-text-input']");
        selectField.waitUntilVisible();
        selectField.click();

        WebElementFacade option = findBy("//div[@role='option' and normalize-space()='" + value + "']");
        option.waitUntilPresent();
        option.click();
    }

    public String getToastMessage() {
        WebElementFacade toastMessage = findBy(".oxd-text--toast-title");
        toastMessage.waitUntilVisible();
        return toastMessage.getText();
    }

    public void clickButtonWithLabel(String label) {
        WebElementFacade button = findBy("//button[contains(@class, 'oxd-button') and contains(normalize-space(), '" + label + "')]");
        button.waitUntilVisible();
        button.click();
    }

    public List<String> getInputValidationErrors(){
        List<WebElementFacade> errors = findAll(".oxd-input-field-error-message");
        return errors.stream().map(WebElementFacade::getText).toList();
    }
}
