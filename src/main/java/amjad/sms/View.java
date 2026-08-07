package amjad.sms;

import java.util.Scanner;

public class View {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller = new Controller();

    public void start() {
        showMenu();
    };

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
        String input = scanner.next();
        return input;
    } 

    private String getInput(String fieldName) {
        System.out.print(fieldName + ": ");
        if (fieldName.equalsIgnoreCase("id")) {
            String input = scanner.next();
            scanner.nextLine();
            return input;
        }

        String input = scanner.nextLine();
        return input;
    }

    private void seeAll() {
        controller.getAll();
    }

    private void seeOne() {
        int id = Integer.parseInt(getInput("ID"));
        controller.getOne(id);
    }

    private void add() {
        int id = Integer.parseInt(getInput("ID"));
        String name = getInput("Name");
        String program = getInput("Program");

        Student student = new Student(id, name, program);
        controller.add(student);
    }

    private void update() {
        int id = Integer.parseInt(getInput("ID"));
        String name = getInput("New Name");
        String program = getInput("New Program");

        Student student = new Student(id, name, program);
        controller.update(student);
    }

    private void delete() {
        int id = Integer.parseInt(getInput("ID"));
        controller.delete(id);
    }
}
