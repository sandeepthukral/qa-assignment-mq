package sandeep.mobiquity.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sandeep.mobiquity.qa.base.TestBase;
import sandeep.mobiquity.qa.pages.EmployeesAddPage;
import sandeep.mobiquity.qa.pages.EmployeesPage;
import sandeep.mobiquity.qa.pages.LoginPage;

import static sandeep.mobiquity.qa.utils.RandomGenerator.getRandomEmail;
import static sandeep.mobiquity.qa.utils.RandomGenerator.getRandomName;

public class EmployeesAddStepDefinitions extends TestBase {

    EmployeesPage employeesPage;
    EmployeesAddPage page;

    @Given("I am on employees page")
    public void iAmOnEmployeesPage() {
        employeesPage = new LoginPage().visit().loginWithCorrectCredentials();
    }

    @When("I click the Create button")
    public void iClickTheCreateButton() {
        page = employeesPage.clickCreateButton();
    }

    @And("I enter employee details")
    public void iEnterEmployeeDetails() {
        String firstName = getRandomName();
        String lastName = getRandomName();
        String date = "2020-01-01";
        String email = getRandomEmail();
        page.createEmployee(firstName, lastName, date, email);
    }

    @And("I save the Employee")
    public void iSaveTheEmployee() {
        page.submitForm();
    }

    @Then("I should see the employee created")
    public void iShouldSeeTheEmployeeCreated() {
    }
}
