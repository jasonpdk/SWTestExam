package live.keane;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeListTest {
    private EmployeeList employeeList;
    private Employee employee;

    @BeforeAll
    public static void init()
    {
        System.out.println("Starting EmployeeList tests");
    }

    @BeforeEach
    public void setUp()
    {
        employeeList = new EmployeeList();
        employee = new Employee();
        employee.setName("Jason Keane");
        employee.setEmployeeNumber("12345");
    }

    @Test
    public void testAddEmployeeSuccess()
    {
        assertEquals(true , employeeList.addEmployee(employee));
        assertEquals(employeeList.getListSize(), 1);
    }

    @Test
    public void testAddEmployeeFail()
    {
        employeeList.addEmployee(employee); // add first employee

        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            employeeList.addEmployee(employee); // add second employee
        });
        assertEquals("Duplicate Employee details found, no object added", ex.getMessage());
        assertEquals(employeeList.getListSize(), 1);
    }

    @Test
    public void testDeleteEmployeeSuccess()
    {
        employeeList.addEmployee(employee); // add first employee
        assertEquals(employeeList.deleteEmployee(employee.getEmployeeNumber()), "Employee deleted from the list");
        assertEquals(employeeList.getListSize(), 0);
    }

    @Test
    public void testDeleteEmployeeFail()
    {
        employeeList.addEmployee(employee); // add first employee

        // create new employee object with different employee number
        Employee employee2 = new Employee();
        employee.setName("Jason Keane");
        employee.setEmployeeNumber("54674");

        assertEquals(employeeList.deleteEmployee(employee2.getEmployeeNumber()), "No matching Employee found");
        assertEquals(employeeList.getListSize(), 1);
    }

    @Test
    public void testGetListSize()
    {
        employeeList.addEmployee(employee);

        Employee employee2 = new Employee();
        employee.setName("First Name");
        employee.setEmployeeNumber("54674");
        employeeList.addEmployee(employee2);

        assertEquals(employeeList.getListSize(), 2);
    }
}
