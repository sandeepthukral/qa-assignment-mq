package sandeep.qa.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.confirm;

public class EmployeeEditPage extends EmployeesAddPage {

    SelenideElement updateButton = $(".formFooter button[type='submit']"),
                    deleteButton = $(".formFooter p.main-button");

    public void setFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.val(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.val(lastName);
    }

    public boolean isEmployeeDetailsDisplayed(String firstName, String lastName) {
        return firstNameInput.val().equals(firstName) && lastNameInput.val().equals(lastName);
    }

    public void update() {
        updateButton.click();
    }

    public void delete() {
        deleteButton.click();
        confirm();
    }

    public EmployeeEditPage updateStartDate(String input) {
        startDateInput.val(input);
        return this;
    }

    public String getStartDate() {
        return startDateInput.val();
    }

    @Override
    public void submitForm() {
        updateButton.click();
    }
}
