package pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.ui.Button;
import org.junit.Assert;
import org.openqa.selenium.By;

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

    public void clickAddJobButton(){
        $(Button.withText("Add")).click();
    }

    public void verifyJobListPage(){
       String currentURL = getDriver().getCurrentUrl();
       Assert.assertTrue(currentURL.contains("viewJobTitleList"));
    }

}
