package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;



public class Hooks {

    @Managed
    WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("Starting Browser....");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        System.out.println("Stopping Browser....");
        if (driver != null) {
            driver.quit();
        }
    }
}
