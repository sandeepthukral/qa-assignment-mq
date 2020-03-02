package sandeep.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import sandeep.qa.base.TestBase;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends TestBase {

    SelenideElement
            username=$("input[type='text']"),
            password=$("input[type='password']"),
            submitButton=$("button[type='submit']"),
            errorMessage=$("p.error-message");

    public LoginPage visit() {
        open("");
        return this;
    }

    public LoginPage enterUsername(String username)  {
        this.username.val(username);
        return this;
    }

    public LoginPage enterPassword(String password)  {
        this.password.val(password);
        return this;
    }

    public void submitForm() {
        this.submitButton.click();
    }

    public LoginPage login(String username, String password) {
        this.enterUsername(username);
        this.enterPassword(password);
        this.submitForm();
        return this;
    }

    public EmployeesPage loginWithCorrectCredentials() {
        String username = prop.getProperty("user.correct.username");
        String password = prop.getProperty("user.correct.password");
        this.login(username, password);
        return new EmployeesPage();
    }

    public boolean isDisplayed() {
        return username.isDisplayed();
    }

    public void waitForErrorMessageToBeDisplayed() {
        errorMessage.shouldNotHave(Condition.cssClass("ng-hide"));
    }
}
