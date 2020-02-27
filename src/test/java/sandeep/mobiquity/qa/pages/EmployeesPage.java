package sandeep.mobiquity.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import sandeep.mobiquity.qa.base.TestBase;

import static com.codeborne.selenide.Selenide.$;

public class EmployeesPage extends TestBase {

    SelenideElement pageMainElement = $(".main-view-wrapper-employees"),
                    logoutButton = $(""),
                    createButton = $(""),
                    editButton = $(""),
                    deleteButton = $(""),
                    employeeList = $("#employee-list");

    public boolean isPageLoaded() {
        return pageMainElement.shouldBe(Condition.visible).exists();
    }

    public boolean isEmployeesListVisible() {
        return employeeList.exists();
    }
}
