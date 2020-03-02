package sandeep.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sandeep.qa.pages.EmployeeEditPage;

import static sandeep.qa.utils.RandomGenerator.getRandomName;

public class EmployeeEditStepDefinitions {

    private Context context;

    EmployeeEditPage employeeEditPage = new EmployeeEditPage();

    public EmployeeEditStepDefinitions (Context context) {
        this.context = context;
    }

    @And("I update the last name")
    public void iUpdateTheLastName() {
        context.firstName = getRandomName();
        context.lastName = getRandomName();
        employeeEditPage.setFirstName(context.firstName);
        employeeEditPage.setLastName(context.lastName);
        employeeEditPage.update();
    }

    @And("I delete the employee")
    public void iDeleteTheEmployee() {
        employeeEditPage.delete();
    }

    @Then("I should be redirected to the employee edit page")
    public void iShouldBeRedirectedToTheEmployeeEditPage() {
        Assert.assertTrue(employeeEditPage.isEmployeeDetailsDisplayed(
                context.employee.getFirstName(),
                context.employee.getLastName()));
    }

    @When("I update the user with an invalid start date")
    public void iUpdateTheUserWithAnInvalidStartDate() {
        employeeEditPage.updateStartDate("InvalidDate").submitForm();
    }

    @Then("the employee start date should remain unchanged")
    public void theEmployeeStartDateShouldRemainUnchanged() {
        Assert.assertEquals("Employee date has been updated",
                            context.employee.getStartDate(),
                            employeeEditPage.getStartDate());
    }
}
