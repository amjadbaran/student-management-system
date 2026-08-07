package amjad.sms;

import java.util.List;

public class Controller {
    private DAO dao = new DAO();

    public void getAll() {
        List<Student> students = dao.retrieveAllRecords(); 

        if (students.isEmpty()) {
            System.out.println("No records found");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void getOne(int id) {
        if (dao.retrieveOneRecord(id) != null) {
            System.out.println(dao.retrieveOneRecord(id));
        } else {
            System.out.println("Student does not exist");
        }
    }

    public void add(Student student) { 
        if (student.getID() <= 0) {
            System.out.println("Invalid ID");
        } else {
            dao.addRecord(student);
            System.out.println("Student added successfully");
        }
    }

    public void update(Student student) {
        if (student.getID() <= 0) {
            System.out.println("Invalid ID");
        } else {
            boolean success = dao.updateRecord(student);
            if (success) {
                System.out.println("Student updated successfully");
            } else {
                System.out.println("Student does not exist");
            }
        }
    }

    public void delete(int id) {
        if(dao.deleteRecord(id)) {
            System.out.println("Student deleted successfully");
        } else {
            System.out.println("Student does not exist");
        }
    }
}