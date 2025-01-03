package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;

public class OrangeHrmCandidateViewPage extends PageObjectBase {
    @FindBy(xpath = "//label[text()='Name']/parent::div/following-sibling::div//p")
    private WebElementFacade nameField;

    public void verifyCurrentPage()
    {
        String currentURL = (getDriver().getCurrentUrl());
        System.out.println(currentURL);
        assert currentURL != null;
        Assert.assertTrue(currentURL.matches(".*recruitment/addCandidate/\\d+"));
    }

    public void verifyNameInField(String firstName, String lastName) {
        String actualName = nameField.getText();
        Assert.assertTrue("First name does not match!", actualName.toLowerCase().contains(firstName.toLowerCase()));
        Assert.assertTrue("Last name does not match!", actualName.toLowerCase().contains(lastName.toLowerCase()));
    }


}
