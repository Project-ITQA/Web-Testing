package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.ui.Button;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.TestUtils;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList")
public class OrangeHrmJobListPage extends PageObject {

    private WebElementFacade getJobTitleRow(String title) {
        for (WebElementFacade row : findAll(By.cssSelector(".oxd-table-row"))) {
            if (row.getText().toLowerCase().contains(title.toLowerCase())) {
                return row;
            }
        }
        return null;
    }

    public void verifyJobTitle(String title) {
        WebElementFacade row = getJobTitleRow(title);
        Assert.assertNotNull(row);
    }

    public void clickAddJobButton() {
        $(Button.withText("Add")).click();
    }

    public void verifyJobListPage() {
        String currentURL = getDriver().getCurrentUrl();
        Assert.assertTrue("Not on the Job List page. Current URL: " + currentURL,
                currentURL.contains("viewJobTitleList"));
    }

    private WebElementFacade getJobDeleteButton(String title) {
        WebElementFacade row = getJobTitleRow(title);
        if (row != null) {
            return row.find(By.xpath("//i[@class='oxd-icon bi-trash']"));
        }
        return null;
    }

    private WebElementFacade getJobEditButton(String title) {
        WebElementFacade row = getJobTitleRow(title);
        if (row != null) {
            return row.find(By.xpath("//i[@class='oxd-icon bi-pencil-fill']"));
        }
        return null;
    }

    public void clickDeleteButton(String title) {
        WebElementFacade deleteButton = getJobDeleteButton(title);
        if (deleteButton != null) {
            deleteButton.click();
        } else {
            Assert.fail("Could not find delete button for title: ");
        }
    }

    public void clickEditButton(String title) {
        WebElementFacade editButton = getJobEditButton(title);
        if (editButton != null) {
            editButton.click();
        }else {
            Assert.fail("Could not find edit button for title: ");
        }
    }

    public void clickConfirmDeleteButton() {
        TestUtils.addDelay(3000); // Ensures page is stable before interacting
        WebElementFacade confirmDeleteButton = find(By.cssSelector(".oxd-button--label-danger"));
        confirmDeleteButton.waitUntilVisible();
        confirmDeleteButton.click();
    }

    public void verifyNotJobRow(String title) {
        WebElementFacade row = getJobTitleRow(title);
        Assert.assertNull(row);
    }
}
