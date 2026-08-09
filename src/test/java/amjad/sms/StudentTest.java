package amjad.sms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    public void testStudentConstructorAndGetters() {
        Student student = new Student(1, "Alice", "BSCS");
        assertEquals(1, student.getID());
        assertEquals("Alice", student.getName());
        assertEquals("BSCS", student.getProgram());
    }

    @Test
    public void testSetters() {
        Student student = new Student();
        student.setID(2);
        student.setName("Bob");
        student.setProgram("SE");

        assertEquals(2, student.getID());
        assertEquals("Bob", student.getName());
        assertEquals("SE", student.getProgram());
    }

    @Test
    public void testToString() {
        Student student = new Student(1, "Alice", "BSCS");
        assertEquals("[1, Alice, BSCS]", student.toString());
    }
}