package pages.wrappers;

import net.serenitybdd.core.pages.PageObject;

public class PageObjectWrapper extends PageObject {

    public boolean verifyPagePath(String path) {
        String url = getDriver().getCurrentUrl();
        assert url != null;
        return url.contains(path);
    }
}
