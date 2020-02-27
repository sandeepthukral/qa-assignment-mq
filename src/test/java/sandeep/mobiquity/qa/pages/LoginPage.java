package sandeep.mobiquity.qa.pages;

import com.codeborne.selenide.SelenideElement;
import sandeep.mobiquity.qa.base.TestBase;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends TestBase {

    SelenideElement
            username=$("input[type='text']"),
            password=$("input[type='password']"),
            submitButton=$("button[type='submit']");

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
}
