package live.keane;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    private Employee employee;

    @BeforeAll
    public static void init()
    {
        System.out.println("Starting Employee tests");
    }

    @BeforeEach
    public void setUp()
    {
        employee = new Employee();
    }

    @Test
    public void testSetNameSuccess()
    {
        employee.setName("Jason Keane");
        assertEquals(employee.getName(), "Jason Keane");
    }

    @Test
    public void testSetNameFail()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            employee.setName("A");
        });

        assertEquals(ex.getMessage(), "Name too short");
    }

    @Test
    public void testSetEmployeeNumberSuccess()
    {
        employee.setEmployeeNumber("12345");
        assertEquals(employee.getEmployeeNumber(), "12345");
    }

    @Test
    public void testSetEmployeeNumberFail()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            employee.setEmployeeNumber("1"); // < 5 digits
        });

        assertEquals(ex.getMessage(), "Employee number must be 5 digits");

        ex = assertThrows(IllegalArgumentException.class, () -> {
            employee.setEmployeeNumber("12345678"); // > 5 digits
        });

        assertEquals(ex.getMessage(), "Employee number must be 5 digits");
    }
}
