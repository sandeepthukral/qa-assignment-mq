package sandeep.qa.pages;

import com.codeborne.selenide.SelenideElement;
import sandeep.qa.base.TestBase;

import static com.codeborne.selenide.Selenide.$;

public class EmployeesAddPage extends TestBase {

    SelenideElement form = $("form[name='employeeForm']"),
                    firstNameInput = $("input[ng-model='selectedEmployee.firstName']"),
                    lastNameInput = $("input[ng-model='selectedEmployee.lastName']"),
                    startDateInput = $("input[ng-model='selectedEmployee.startDate']"),
                    emailInput = $("input[ng-model='selectedEmployee.email']"),
                    addSubmitButton = $("button[type='submit']", 1),
                    cancelButton = $ (".bCancel");
    ;

    public void enterEmployeeDetails(String firstName, String lastName, String startDate, String email) {
        firstNameInput.val(firstName);
        lastNameInput.val(lastName);
        startDateInput.val(startDate);
        emailInput.val(email);
    }

    public void submitForm() {
        addSubmitButton.click();
    }

    public void clickCancelButon() {
        cancelButton.click();
    }
}
