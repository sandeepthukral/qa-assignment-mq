package sandeep.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import sandeep.qa.base.TestBase;
import sandeep.qa.pages.EmployeesAddPage;
import sandeep.qa.pages.EmployeesPage;
import sandeep.qa.pages.LoginPage;

import static sandeep.qa.utils.RandomGenerator.getRandomEmail;
import static sandeep.qa.utils.RandomGenerator.getRandomName;

public class EmployeeAddStepDefinitions extends TestBase {

    private Context context;

    EmployeesPage employeesPage = new EmployeesPage();
    EmployeesAddPage page = new EmployeesAddPage();

    public EmployeeAddStepDefinitions(Context context) {
        this.context = context;
    }

    @Given("I am on employees page")
    public void iAmOnEmployeesPage() {
        employeesPage = new LoginPage().visit().loginWithCorrectCredentials();
    }

    @Given("I visit the employees page")
    public void iVisitTheEmployeesPage() {
        employeesPage.visit();
    }

    @When("I click the Create button")
    public void iClickTheCreateButton() {
        page = employeesPage.clickCreateButton();
    }

    @And("I enter employee details")
    public void iEnterEmployeeDetails() {
        String firstName = getRandomName();
        String lastName = getRandomName();
        String startDate = "2020-01-01";
        String email = getRandomEmail();
        context.firstName = firstName;
        context.lastName = lastName;
        context.email = email;
        page.createEmployee(firstName, lastName, startDate, email);
    }

    @And("I save the Employee")
    public void iSaveTheEmployee() {
        page.submitForm();
    }
}