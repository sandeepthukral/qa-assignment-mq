package sandeep.qa.steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import sandeep.qa.pages.EmployeesPage;
import sandeep.qa.pages.LoginPage;
import sandeep.qa.utils.Cleanups;
import sandeep.qa.utils.Employee;

import java.util.Set;

import static com.codeborne.selenide.Selenide.$;
import static sandeep.qa.utils.RandomGenerator.getRandomEmail;
import static sandeep.qa.utils.RandomGenerator.getRandomName;

public class BackgroundStepDefinitions {

    LoginPage loginPage = new LoginPage();
    EmployeesPage employeesPage = new EmployeesPage();

    private Context context;

    public BackgroundStepDefinitions(Context context) {
        this.context = context;
    }

    @Given("a newly created employee")
    public void aNewlyCreatedEmployee() {
        loginPage.visit().loginWithCorrectCredentials();
        employeesPage.clickCreateButton();
        context.cookieValue = getCookieValue();
        context.csrfToken = getCsrfToken();

        String firstName = getRandomName();
        String lastName = getRandomName();
        String startDate = "2020-01-01";
        String email = getRandomEmail();

        // Create employee by callignthe endpoint and store the employee ID for cleanup
        context.employeeId = context.endpointsApi.createEmployee(firstName, lastName, startDate, email);
        context.employee = new Employee(firstName, lastName, startDate, email);

        // set the employee for deletion at the end of the test
        context.laterExecution.addMethod(new Cleanups(context).cleanupEmployee);
    }

    // We need a specific cookie for using in Endpoint calls
    String getCookieValue() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("_CafeTownsend-Angular-Rails_session")) {
                return cookie.getValue();
            }
        }
        return "";
    }

    // The CSRF token is required for using in Endpoint calls
    String getCsrfToken() {
        return $("meta[name='csrf-token']").getAttribute("content");
    }
}
