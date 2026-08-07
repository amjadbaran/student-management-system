package amjad.sms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    public DAO() { }

    public List<Student> retrieveAllRecords() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DatabaseConfig.gConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql); 
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Student student = new Student();
                student.setID(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setProgram(rs.getString("program"));

                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    public Student retrieveOneRecord(int id) {
        String sql = "SELECT * FROM students WHERE id = ?"; 

        try (Connection conn = DatabaseConfig.gConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id); 
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Student student = new Student();
                    student.setID(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setProgram(rs.getString("program"));

                    return student;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean addRecord(Student student) {
        String sql = "INSERT INTO students (id, name, program) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConfig.gConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, student.getID());
            ps.setString(2, student.getName());
            ps.setString(3, student.getProgram());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean updateRecord(Student student) {
        String sql = "UPDATE students SET name = ?, program = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.gConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, student.getName());
            ps.setString(2, student.getProgram());
            ps.setInt(3, student.getID());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean deleteRecord(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DatabaseConfig.gConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}