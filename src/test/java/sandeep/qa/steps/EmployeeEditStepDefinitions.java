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

    @And("I delete the employee")
    public void iDeleteTheEmployee() {
        employeeEditPage.delete();
    }

    @Then("I should be redirected to the employee edit page")
    public void iShouldBeRedirectedToTheEmployeeEditPage() {
        Assert.assertTrue("The employee page is not loaded",
                employeeEditPage.isEmployeeDetailsDisplayed(
                context.employee.getFirstName(),
                context.employee.getLastName()));
    }

    @When("I update the user with an invalid start date")
    public void iUpdateTheUserWithAnInvalidStartDate() {
        employeeEditPage.setStartDate("InvalidDate").submitForm();
    }

    @Then("the employee start date should remain unchanged")
    public void theEmployeeStartDateShouldRemainUnchanged() {
        Assert.assertEquals("Employee date has been updated",
                            context.employee.getStartDate(),
                            employeeEditPage.getStartDate());
    }

    @And("I update the employee with a new first and last name")
    public void iUpdateTheEmployeeWithANewFirstAndLastName() {
        String newFirstName = getRandomName();
        String newLastName = getRandomName();
        employeeEditPage.setFirstName(newFirstName);
        employeeEditPage.setLastName(newLastName);
        employeeEditPage.clickUpdateButton();
        context.employee.setFirstName(newFirstName);
        context.employee.setLastName(newLastName);
    }

    @And("I set new first and last name")
    public void iEditTheFirstAndLastName() {
        String newFirstName = getRandomName();
        String newLastName = getRandomName();
        employeeEditPage.setFirstName(newFirstName);
        employeeEditPage.setLastName(newLastName);
    }

    @And("I click the Back button")
    public void iClickTheBackButton() {
        employeeEditPage.clickBackButton();
    }

    @When("I update the user with an invalid email")
    public void iUpdateTheUserWithAnInvalidEmail() {
        employeeEditPage.setEmail("InvalidEmail");
    }

    @And("I update the employee")
    public void iUpdateTheEmployee() {
        employeeEditPage.clickUpdateButton();
    }

    @Then("the email field is marked invalid")
    public void theEmailFieldIsMarkedInvalid() {
        Assert.assertTrue("Email input field was not marked invalid", employeeEditPage.isEmailInputInvalid());
    }

    @And("the employee is not updated")
    public void theEmployeeIsNotUpdated() {
        Assert.assertTrue("The employee details were updated", employeeEditPage.isEmployeeDetailsDisplayed(
                context.employee.getFirstName(),
                context.employee.getLastName()));
    }
}
