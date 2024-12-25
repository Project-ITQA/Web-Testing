package pages;

import net.serenitybdd.annotations.Step;

public class EmployeeSteps extends AuthenticatedBaseTest{

    EmployeePage employeePage;

    @Step
    public void openEmployeePage() {
        loginAsAdmin();


    }
}
