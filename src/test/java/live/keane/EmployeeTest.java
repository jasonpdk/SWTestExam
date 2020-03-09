/*
 * Employee Test
 * Jason Keane
 */
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
        assertEquals("Jason Keane", employee.getName());
    }

    @Test
    public void testSetNameFail()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            employee.setName("A");
        });

        assertEquals("Name too short", ex.getMessage());
    }

    @Test
    public void testSetEmployeeNumberSuccess()
    {
        employee.setEmployeeNumber("12345");
        assertEquals("12345", employee.getEmployeeNumber());
    }

    @Test
    public void testSetEmployeeNumberFail()
    {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            employee.setEmployeeNumber("1"); // < 5 digits
        });

        assertEquals("Employee number must be 5 digits", ex.getMessage());

        ex = assertThrows(IllegalArgumentException.class, () -> {
            employee.setEmployeeNumber("12345678"); // > 5 digits
        });

        assertEquals("Employee number must be 5 digits", ex.getMessage());
    }
}
