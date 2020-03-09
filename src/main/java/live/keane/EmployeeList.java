/*
 * Employee List
 * Jason Keane
 */

package live.keane;

import java.util.ArrayList;

public class EmployeeList {
    private ArrayList<Employee> employees;

    public EmployeeList() {
        this.employees = new ArrayList<Employee>();
    }

    public boolean addEmployee(Employee emp)
    {
        // check if number exists, throw exception
        for (int i = 0; i < employees.size(); i++) {
            Employee currentEmployee = employees.get(i);
            if (currentEmployee.getEmployeeNumber().equals(emp.getEmployeeNumber())) {
                throw new IllegalArgumentException("Duplicate Employee details found, no object added");
            }
        }

        employees.add(emp);
        return true;
    }

    public String deleteEmployee(String employeeNumber)
    {
        for (int i = 0; i < employees.size(); i++) {
            Employee currentEmployee = employees.get(i);
            if (currentEmployee.getEmployeeNumber().equals(employeeNumber)) {
                employees.remove(i);
                return "Employee deleted from the list";
            }
        }

        return "No matching Employee found";
    }

    public int getListSize()
    {
        return employees.size();
    }
}
