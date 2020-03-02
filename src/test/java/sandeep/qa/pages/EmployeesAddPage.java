package sandeep.qa.pages;

import com.codeborne.selenide.SelenideElement;
import sandeep.qa.base.TestBase;

import static com.codeborne.selenide.Selenide.$;

public class EmployeesAddPage extends TestBase {

    SelenideElement form = $("form[name='employeeForm']"),
                    firstNameInput = $("input[ng-model='selectedEmployee.firstName']"),
                    lastNameInput = $("input[ng-model='selectedEmployee.lastName']"),
                    dateInput = $("input[ng-model='selectedEmployee.startDate']"),
                    emailInput = $("input[ng-model='selectedEmployee.email']"),
                    submitButton = $("button[type='submit']", 1);
    ;

    public void createEmployee(String firstName, String lastName, String date, String email) {
        firstNameInput.val(firstName);
        lastNameInput.val(lastName);
        dateInput.val(date);
        emailInput.val(email);
    }

    public void submitForm() {
        submitButton.click();
    }
}
