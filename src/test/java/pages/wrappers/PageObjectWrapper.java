package pages.wrappers;

import net.serenitybdd.core.pages.PageObject;

public class PageObjectWrapper extends PageObject {

    public boolean verifyURLContains(String expectedPath) {
        String currentURL = getDriver().getCurrentUrl();
        assert currentURL != null;
        return currentURL.contains(expectedPath);
    }
}
