package amjad.sms;
import jakarta.persistence.*;

@Entity 
@Table(name = "students")
public class Student {

    @Id 
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "program", nullable = false)
    private String program;

    public Student () {}

    public Student(int id, String name, String program) {
        this.id = id;
        this.name = name;
        this.program = program;
    } 
    
    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return this.program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String toString() {
        return "[" + id + ", " + name + ", " + program + "]";
    }
}
