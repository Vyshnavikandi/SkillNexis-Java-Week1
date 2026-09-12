package View;

import Controller.StudentController;
import Model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentView {

    private Scanner scanner;
    private StudentController controller;

    public StudentView() {
        scanner = new Scanner(System.in);
        controller = new StudentController();
    }

    public void start() {

        while (true) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    updateStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ADD
    private void addStudent() {

        System.out.println("\n--- Add Student ---");

        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Branch: ");
        String branch = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        Student student =
                new Student(id, name, branch, marks, email);

        controller.addStudent(student);
    }

    // VIEW
    private void viewStudents() {

        System.out.println("\n--- Student List ---");

        ArrayList<Student> students =
                controller.viewStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {

            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // UPDATE
    private void updateStudent() {

        System.out.println("\n--- Update Student ---");

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Branch: ");
        String branch = scanner.nextLine();

        System.out.print("Enter New Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter New Email: ");
        String email = scanner.nextLine();

        Student student =
                new Student(id, name, branch, marks, email);

        controller.updateStudent(student);
    }

    // DELETE
    private void deleteStudent() {

        System.out.println("\n--- Delete Student ---");

        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();

        controller.deleteStudent(id);
    }
}