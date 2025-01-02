package utils;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class TestUtils {
    public static void addDelay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void selectOptionFrom(List<WebElementFacade> visibleOptions, String option){
        for (WebElementFacade element :
                visibleOptions) {
            element.waitUntilVisible();

            if (element.containsText(option)) {
                element.click();
                break;
            }
        }
    }
}