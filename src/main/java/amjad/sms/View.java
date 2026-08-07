package amjad.sms;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller = new Controller();

    public void start() {
        showMenu();
    }

    private void showMenu() {
        while (true) { 
            System.out.println("\n====== Student Management System ======"); 
            System.out.println();

            System.out.println("1) See All Records");
            System.out.println("2) Get Specific Student");
            System.out.println("3) Add Student");
            System.out.println("4) Update Student");
            System.out.println("5) Delete Student");
            System.out.println("6) Exit");

            try {
                int input = Integer.parseInt(getInput());

                if (input == 1) {
                    seeAll();
                } else if (input == 2) {
                    seeOne();
                } else if (input == 3) {
                    add();
                } else if (input == 4) {
                    update();
                } else if (input == 5) {
                    delete();
                } else if (input == 6) {
                    System.out.println("Goodbye!");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Wrong input");
            }
        }
    }

    private String getInput() {
        System.out.print("$ >>> ");
        return scanner.next();
    } 

    private String getInput(String fieldName) {
        System.out.print(fieldName + ": ");
        if (fieldName.equalsIgnoreCase("id")) {
            String input = scanner.next();
            scanner.nextLine(); // Clear buffer
            return input;
        }

        return scanner.nextLine();
    }

    private void seeAll() {
        List<Student> students = controller.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No records found");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private void seeOne() {
        int id = Integer.parseInt(getInput("ID"));
        Student student = controller.getStudent(id);

        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student does not exist");
        }
    }

    private void add() {
        int id = Integer.parseInt(getInput("ID"));
        String name = getInput("Name");
        String program = getInput("Program");

        Student student = new Student(id, name, program);
        boolean success = controller.addStudent(student);

        if (success) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Failed to add student. Invalid ID (must be > 0) or ID already exists.");
        }
    }

    private void update() {
        int id = Integer.parseInt(getInput("ID"));
        String name = getInput("New Name");
        String program = getInput("New Program");

        Student student = new Student(id, name, program);
        boolean success = controller.updateStudent(student);

        if (success) {
            System.out.println("Student updated successfully");
        } else {
            System.out.println("Student does not exist");
        }
    }

    private void delete() {
        int id = Integer.parseInt(getInput("ID"));
        boolean success = controller.deleteStudent(id);

        if (success) {
            System.out.println("Student deleted successfully");
        } else {
            System.out.println("Student does not exist");
        }
    }
}