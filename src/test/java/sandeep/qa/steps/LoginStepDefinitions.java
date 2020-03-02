package sandeep.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sandeep.qa.base.TestBase;
import sandeep.qa.pages.EmployeesPage;
import sandeep.qa.pages.LoginPage;

public class LoginStepDefinitions extends TestBase {

    private Context context;

    LoginPage page = new LoginPage();
    EmployeesPage employeesPage = new EmployeesPage();

    public LoginStepDefinitions(Context context) {
        this.context = context;
    }

    @Given("the login page")
    public void theLoginPage() {
        page.visit();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        Assert.assertTrue(employeesPage.isPageLoaded());
    }

    @And("the list of employees should be displayed")
    public void theListOfEmployeesShouldBeDisplayed() {
        Assert.assertTrue(employeesPage.isEmployeesListVisible());
    }

    @When("I enter correct credentials and login")
    public void iEnterCorrectCredentialsAndLogin() {
        page.enterUsername(prop.getProperty("user.correct.username"))
                .enterPassword(prop.getProperty("user.correct.password"))
                .submitForm();
    }

    @Then("I should see the employee created")
    public void iShouldSeeTheEmployeeCreated() {
        Assert.assertTrue(employeesPage.isEmployeeListed(context.firstName + " " + context.lastName));
    }
}
