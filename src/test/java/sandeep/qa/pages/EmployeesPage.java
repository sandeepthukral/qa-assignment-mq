package sandeep.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import sandeep.qa.base.TestBase;

import java.util.Collection;
import java.util.List;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class EmployeesPage extends TestBase {

    SelenideElement pageMainElement = $(".main-view-wrapper-employees"),
                    logoutButton = $("header .main-button"),
                    createButton = $("#bAdd"),
                    editButton = $("#bEdit"),
                    deleteButton = $("#bDelete"),
                    employeeList = $("#employee-list"),
                    greeting = $("#greetings");

    public EmployeesPage visit() {
        open("employees");
        return this;
    }

    public boolean isPageLoaded() {
        return pageMainElement.shouldBe(Condition.visible).exists();
    }

    public boolean isEmployeesListVisible() {
        return employeeList.shouldBe(Condition.visible).exists();
    }

    public EmployeesAddPage clickCreateButton() {
        createButton.click();
        return new EmployeesAddPage();
    }

    public boolean isEmployeeListed(String name) {
        sleep(2000);
        List<String> employeeNames = $$("ul#employee-list li").texts();
        return employeeNames.contains(name);
    }

    public void doubleClickEmployee(String name){
        $(withText(name)).doubleClick();
    }

    public void selectEmployee(String name){
        $(withText(name)).click();
    }

    public void logout() {
        logoutButton.click();
    }

    public void clickEditButton() {
        editButton.click();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public void confirmDeleteDialog() {
        confirm();
    }

    public String getGreeting() {
        return greeting.innerText().trim();
    }

    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }

    public boolean isCreateButtonEnabled() {
        return this.isButtonEnabled(createButton);
    }

    public boolean isEditButtonEnabled() {
        return this.isButtonEnabled(editButton);
    }
    public boolean isDeleteButtonEnabled() {
        return this.isButtonEnabled(deleteButton);
    }

    private boolean isButtonEnabled(SelenideElement element){
        String classes = element.getAttribute("class");
        return !classes.contains("disabled");
    }

}
