package amjad.sms;

import java.util.List;

public class Controller {
    private DAO dao = new DAO();

    public List<Student> getAllStudents() {
        return dao.retrieveAllRecords();
    }

    public Student getStudent(int id) {
        return dao.retrieveOneRecord(id);
    }

    public boolean addStudent(Student student) {
        // Business rule: ID must be positive
        if (student.getID() <= 0) {
            return false;
        }
        return dao.addRecord(student);
    }

    public boolean updateStudent(Student student) {
        // Business rule: ID must be positive
        if (student.getID() <= 0) {
            return false;
        }
        return dao.updateRecord(student);
    }

    public boolean deleteStudent(int id) {
        return dao.deleteRecord(id);
    }
}