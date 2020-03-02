package sandeep.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sandeep.qa.pages.EmployeesPage;

public class EmployeesStepDefinitions {

    private Context context;

    public EmployeesStepDefinitions(Context context){
        this.context = context;
    }

    EmployeesPage employeesPage = new EmployeesPage();

    @When("I select the employee")
    public void iSelectTheEmployee() {
        employeesPage.selectEmployee(context.employee.getFirstName() + " " + context.employee.getLastName());
    }

    @When("I double click the employee")
    public void iDoubleClickTheEmployee() {
        employeesPage.doubleClickEmployee(context.employee.getFirstName() + " " + context.employee.getLastName());
    }

    @And("I should see the updated name displayed")
    public void iShouldSeeTheUpdatedNameDisplayed() {
        Assert.assertTrue(employeesPage.isEmployeeListed(context.firstName + " " + context.lastName));
    }

    @And("I click the Edit button")
    public void iClickTheEditButton() {
        employeesPage.clickEditButton();
    }

    @And("I click the Delete button")
    public void iClickTheDeleteButton() {
        employeesPage.clickDeleteButton();
    }

    @And("I logout")
    public void iLogout() {
        employeesPage.logout();
    }

    @Then("I should not see the employee")
    public void iShouldNotSeeTheEmployee() {
        Assert.assertFalse("Employee was not deleted",
                            employeesPage.isEmployeeListed(
                                    context.employee.getFirstName() + " " + context.employee.getLastName())
        );
    }

    @And("confirm the delete dialog")
    public void confirmTheDeleteDialog() {
        employeesPage.confirmDeleteDialog();
    }
}
