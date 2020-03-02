package sandeep.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import sandeep.qa.base.TestBase;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class EmployeesPage extends TestBase {

    SelenideElement pageMainElement = $(".main-view-wrapper-employees"),
                    logoutButton = $(""),
                    createButton = $("#bAdd"),
                    editButton = $("#bEdit"),
                    deleteButton = $("#bDelete"),
                    employeeList = $("#employee-list");

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
        sleep(1000);
        List<String> employeeNames = $$("ul#employee-list li").texts();
        return employeeNames.contains(name);
    }
}
