package utils;

import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class TestUtils {
    private static final int defaultDelay = 3000;

    public static void addDelay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void addDelay() {
        try {
            Thread.sleep(defaultDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static WebElementFacade findElement(List<WebElementFacade> list, String textContent) {
        return list.stream().filter(
                item -> {
                    item.waitUntilVisible();
                    return item.getText().equalsIgnoreCase(textContent);
                }
        ).findFirst().orElse(null);
    }
}