package amjad.sms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    @Test
    public void testAddStudentInvalidId() {
        Controller controller = new Controller();
        Student invalidStudent = new Student(0, "Invalid", "BSCS");

        // Business rule: ID must be positive (> 0)
        boolean result = controller.addStudent(invalidStudent);
        assertFalse(result);
    }

    @Test
    public void testUpdateStudentInvalidId() {
        Controller controller = new Controller();
        Student invalidStudent = new Student(-5, "Invalid", "BSCS");

        // Business rule: ID must be positive (> 0)
        boolean result = controller.updateStudent(invalidStudent);
        assertFalse(result);
    }
}