package amjad.sms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DAOTest {

    private DAO dao;

    @BeforeEach
    public void setUp() {
        dao = new DAO();
    }

    @AfterEach
    public void tearDown() {
        // Clean up database records after each test
        List<Student> students = dao.retrieveAllRecords();
        for (Student s : students) {
            dao.deleteRecord(s.getID());
        }
    }

    @Test
    public void testAddAndRetrieveRecord() {
        Student student = new Student(101, "John Doe", "BSCS");
        boolean isAdded = dao.addRecord(student);
        assertTrue(isAdded);

        Student retrieved = dao.retrieveOneRecord(101);
        assertNotNull(retrieved);
        assertEquals("John Doe", retrieved.getName());
        assertEquals("BSCS", retrieved.getProgram());
    }

    @Test
    public void testRetrieveAllRecords() {
        dao.addRecord(new Student(1, "Alice", "SE"));
        dao.addRecord(new Student(2, "Bob", "IT"));

        List<Student> students = dao.retrieveAllRecords();
        assertEquals(2, students.size());
    }

    @Test
    public void testUpdateRecord() {
        Student student = new Student(102, "Charlie", "Cyber Security");
        dao.addRecord(student);

        student.setName("Charlie Updated");
        boolean isUpdated = dao.updateRecord(student);
        assertTrue(isUpdated);

        Student updated = dao.retrieveOneRecord(102);
        assertEquals("Charlie Updated", updated.getName());
    }

    @Test
    public void testDeleteRecord() {
        Student student = new Student(103, "David", "AI");
        dao.addRecord(student);

        boolean isDeleted = dao.deleteRecord(103);
        assertTrue(isDeleted);

        Student retrieved = dao.retrieveOneRecord(103);
        assertNull(retrieved);
    }
}