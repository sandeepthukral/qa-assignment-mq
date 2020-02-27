package sandeep.mobiquity.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sandeep.mobiquity.qa.base.TestBase;
import sandeep.mobiquity.qa.pages.EmployeesPage;
import sandeep.mobiquity.qa.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginStepDefinitions extends TestBase {

    LoginPage page = new LoginPage();
    EmployeesPage employeesPage = new EmployeesPage();

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
}
