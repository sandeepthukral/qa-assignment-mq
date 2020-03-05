package sandeep.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sandeep.qa.base.TestBase;
import sandeep.qa.pages.EmployeesPage;
import sandeep.qa.pages.LoginPage;

import static sandeep.qa.utils.RandomGenerator.*;

public class LoginStepDefinitions extends TestBase {

    private Context context;

    LoginPage loginPage = new LoginPage();
    EmployeesPage employeesPage = new EmployeesPage();

    public LoginStepDefinitions(Context context) {
        this.context = context;
    }

    @Given("the login page")
    public void theLoginPage() {
        loginPage.visit();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        Assert.assertTrue("Employees page was not loaded", employeesPage.isPageLoaded());
    }

    @And("the list of employees should be displayed")
    public void theListOfEmployeesShouldBeDisplayed() {
        Assert.assertTrue("Employees page is not displayed", employeesPage.isEmployeesListVisible());
    }

    @When("I enter correct credentials and login")
    public void iEnterCorrectCredentialsAndLogin() {
        loginPage.enterUsername(config.get("user.correct.username"))
                .enterPassword(config.get("user.correct.password"))
                .submitForm();
    }

    @Then("I should see the employee created")
    public void iShouldSeeTheEmployeeCreated() {
        Assert.assertTrue("Employee was not listed", employeesPage.isEmployeeListed(context.employee.getName()));
    }

    @When("I enter random credentials and login")
    public void iEnterRandomCredentialsAndLogin() {
        loginPage.enterUsername(getRandomUsername()).enterPassword(getRandomPassword()).submitForm();
    }

    @Then("I should not be logged in")
    public void iShouldNotBeLoggedIn() {
        Assert.assertTrue("Login page was not displayed", loginPage.isDisplayed());
    }

    @And("and invalid credentials message should be displayed")
    public void andInvalidCredentialsMessageShouldBeDisplayed() {
        loginPage.waitForErrorMessageToBeDisplayed();
    }

    @When("I enter correct username and incorrect password and login")
    public void iEnterCorrectUsernameAndIncorrectPasswordAndLogin() {
        loginPage
                .enterUsername(config.get("user.correct.username"))
                .enterPassword(getRandomPassword())
                .submitForm();
    }

    @When("I enter incorrect username and correct password and login")
    public void iEnterIncorrectUsernameAndCorrectPasswordAndLogin() {
        loginPage
                .enterUsername(getRandomUsername())
                .enterPassword(config.get("user.correct.password"))
                .submitForm();
    }

    @When("I enter no credentials and login")
    public void iEnterNoCredentialsAndLogin() {
        loginPage.submitForm();
    }
}
