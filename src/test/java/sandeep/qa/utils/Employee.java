package sandeep.qa.utils;

public class Employee {
    String firstName;
    String lastName;
    String startDate;
    String email;

    public Employee(String firstName, String lastName, String startDate, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
        this.email = email;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getStartDate() {
        return this.startDate;
    }

    public void setFirstName(String firstName) { this.firstName = firstName;}

    public void setLastName(String lastName) { this.lastName = lastName;}
}
