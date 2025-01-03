package pages;

import net.serenitybdd.annotations.DefaultUrl;
import pages.components.SideNavigationMenu;
import utils.PagePaths;

@DefaultUrl(PagePaths.DASHBOARD)
public class DashboardPage extends PageObjectBase {

    SideNavigationMenu sideNavigationMenu;

    public void clickMenuItem(String menuItemName) {
        sideNavigationMenu.clickMenuItem(menuItemName);
    }
}
