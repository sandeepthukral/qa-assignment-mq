package sandeep.qa.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.confirm;

public class EmployeeEditPage extends EmployeesAddPage {

    SelenideElement updateButton = $(".formFooter button[type='submit']"),
                    deleteButton = $(".formFooter p.main-button"),
                    backButton = $(".bBack");

    public void setFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.val(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.val(lastName);
    }

    public EmployeeEditPage setStartDate(String input) {
        startDateInput.val(input);
        return this;
    }

    public void setEmail(String value) {
        emailInput.val(value);
    }

    public boolean isEmployeeDetailsDisplayed(String firstName, String lastName) {
        return firstNameInput.val().equals(firstName) && lastNameInput.val().equals(lastName);
    }

    public void clickUpdateButton() {
        updateButton.click();
    }

    public void delete() {
        deleteButton.click();
        confirm();
    }

    public String getStartDate() {
        return startDateInput.val();
    }

    public boolean isEmailInputInvalid() {
        return !this.isInputFieldValid(emailInput);
    }

    public void clickBackButton() {
        backButton.click();
    }

    @Override
    public void submitForm() {
        updateButton.click();
    }

    private boolean isInputFieldValid(SelenideElement element) {
        String classes = element.getAttribute("class");
        System.out.println(classes);
        return !classes.contains("ng-invalid");
    }
}
