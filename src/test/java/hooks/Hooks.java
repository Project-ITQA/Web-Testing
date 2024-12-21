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

        // Dynamically select browser (Edge or Chrome)
        String selectedBrowser = BrowserSelector.getDefaultBrowser();
        System.setProperty("webdriver.driver", selectedBrowser);

        // Get the driver and maximize the window
        driver = ThucydidesWebDriverSupport.getDriver();
        driver.manage().window().maximize();

        System.out.println("Browser started: " + selectedBrowser);
    }

    @After
    public void tearDown() {
        System.out.println("Stopping Browser...");
        if (driver != null) {
            driver.quit();
            System.out.println("Browser stopped.");
        }
    }
}
