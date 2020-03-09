/*
 * Employee
 * Jason Keane
 */

package live.keane;

public class Employee {
    private String name;
    private String employeeNumber;

    public Employee() {
        System.out.println("Constructor");
        this.name = "";
        this.employeeNumber = "0";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 5) {
            throw new IllegalArgumentException("Name too short");
        }

        this.name = name;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        if (employeeNumber.length() < 5 || employeeNumber.length() > 5) {
            throw new IllegalArgumentException("Employee number must be 5 digits");
        }

        this.employeeNumber = employeeNumber;
    }
}
