package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class EmployeePage {

    @FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']")
    private WebElement pimMenuItem;

    public void navigateToAddEmployee()
    {
pimMenuItem.click();
    }


    //a[contains(text(), 'Add Employee')]

}
