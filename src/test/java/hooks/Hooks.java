package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.WebDriver;
import utils.BrowserSelector;

public class Hooks {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Starting Browser...");

        String selectedBrowser = System.getProperty("browser", BrowserSelector.getDefaultBrowser());
        System.setProperty("webdriver.driver", selectedBrowser);

        try {
            driver = ThucydidesWebDriverSupport.getDriver();
            driver.manage().window().maximize();
            System.out.println("Browser started: " + selectedBrowser);
        } catch (Exception e) {
            System.err.println("Failed to start the browser: " + e.getMessage());
            throw e;
        }
    }

    @After
    public void tearDown() {
        System.out.println("Stopping Browser...");
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("Browser stopped.");
            } catch (Exception e) {
                System.err.println("Error while stopping the browser: " + e.getMessage());
            }
        }
    }
}
