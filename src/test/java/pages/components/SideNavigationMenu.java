package pages.components;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import pages.PageObjectBase;
import utils.TestUtils;

import java.util.List;

public class SideNavigationMenu extends PageObjectBase {

    @FindBy(css = "span.oxd-text.oxd-main-menu-item--name")
    private List<WebElementFacade> menuItems;

    public void clickMenuItem(String menuItemName) {
        TestUtils.findElement(menuItems, menuItemName).click();
    }

}
