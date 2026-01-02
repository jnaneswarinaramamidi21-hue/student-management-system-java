/**
 * StudentManagementSystem.java
 * Console-based application to manage student records.
 * Humanised version for readability and learning purposes.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: System.out.println("Exiting program. Thank you!"); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    // Show menu options
    private static void showMenu() {
        System.out.println("\n===== Student Management System =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Update Student Details");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    // Add new student
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        students.add(new Student(id, name, age, department));
        System.out.println(" Student added successfully.");
    }

    // View all students
    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("⚠ No students found.");
            return;
        }

        System.out.println("\nID\tName\tAge\tDepartment");
        System.out.println("-------------------------------");
        for (Student s : students) {
            s.display();
        }
    }

    // Search a student by ID
    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("\n Student Found:");
                System.out.println("ID\tName\tAge\tDepartment");
                s.display();
                return;
            }
        }

        System.out.println("⚠ Student not found.");
    }

    // Update student details
    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                s.setName(sc.nextLine());

                System.out.print("Enter new age: ");
                s.setAge(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter new department: ");
                s.setDepartment(sc.nextLine());

                System.out.println(" Student details updated successfully.");
                return;
            }
        }

        System.out.println(" Student not found.");
    }

    // Delete student
    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        boolean removed = students.removeIf(s -> s.getId() == id);

        if (removed) {
            System.out.println(" Student deleted successfully.");
        } else {
            System.out.println(" Student not found.");
        }
    }
}
