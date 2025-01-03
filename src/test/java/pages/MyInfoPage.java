package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import utils.PagePaths;
import utils.TestUtils;

import java.util.List;

@DefaultUrl(PagePaths.MY_INFO)
public class MyInfoPage extends PageObjectBase {

    @FindBy(css = ".orangehrm-tabs-item")
    private List<WebElementFacade> sectionItems;

    @FindBy(css = "h6.oxd-text.oxd-text--h6.orangehrm-main-title")
    private WebElementFacade sectionTitle;

    public void clickSectionItem(String sectionItemName) {
        TestUtils.findElement(sectionItems, sectionItemName).click();
    }

    public boolean verifySection(String section) {
        return sectionTitle.getText().equalsIgnoreCase(section);
    }
}
