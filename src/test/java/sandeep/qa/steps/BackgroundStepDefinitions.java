package sandeep.qa.steps;

import io.cucumber.java.en.Given;
import sandeep.qa.pages.EmployeesAddPage;
import sandeep.qa.pages.EmployeesPage;
import sandeep.qa.pages.LoginPage;
import sandeep.qa.utils.Employee;

import static sandeep.qa.utils.RandomGenerator.getRandomEmail;
import static sandeep.qa.utils.RandomGenerator.getRandomName;

public class BackgroundStepDefinitions {

    LoginPage loginPage = new LoginPage();
    EmployeesPage employeesPage = new EmployeesPage();
    EmployeesAddPage employeesAddPage = new EmployeesAddPage();

    private Context context;

    public BackgroundStepDefinitions(Context context) {
        this.context = context;
    }

    @Given("a newly created employee")
    public void aNewlyCreatedEmployee() {
        loginPage.visit().loginWithCorrectCredentials();
        employeesPage.isPageLoaded();
        employeesPage.clickCreateButton();

        String firstName = getRandomName();
        String lastName = getRandomName();
        String startDate = "2020-01-01";
        String email = getRandomEmail();
        context.employee = new Employee(firstName, lastName, startDate, email);

        employeesAddPage.createEmployee(firstName, lastName, startDate, email);
        employeesAddPage.submitForm();
    }
}
