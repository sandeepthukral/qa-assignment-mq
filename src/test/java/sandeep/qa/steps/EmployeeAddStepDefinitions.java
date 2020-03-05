package sandeep.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import sandeep.qa.base.TestBase;
import sandeep.qa.pages.EmployeesAddPage;
import sandeep.qa.pages.EmployeesPage;
import sandeep.qa.pages.LoginPage;
import sandeep.qa.utils.Employee;

import static com.codeborne.selenide.Selenide.confirm;
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
        context.employee = new Employee(firstName, lastName, startDate, email);
        page.enterEmployeeDetails(firstName, lastName, startDate, email);
    }

    @And("I enter employee details with invalid date")
    public void iEnterEmployeeDetailsWithIncorrectDate() {
        String firstName = getRandomName();
        String lastName = getRandomName();
        String startDate = "Invalid Date";
        String email = getRandomEmail();
        page.enterEmployeeDetails(firstName, lastName, startDate, email);
    }

    @And("I add the Employee")
    public void iAddTheEmployee() {
        page.submitForm();
    }

    @Then("the start date cannot be empty dialog should be displayed")
    public void theStartDateCannotBeEmptyDialogShouldBeDisplayed() {
        confirm("Error trying to create a new employee: {\"start_date\":[\"can't be blank\"]})");
    }

    @And("I click the Cancel button")
    public void iClickTheCancelButton() {
        page.clickCancelButon();
    }
}
