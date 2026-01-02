/**
 * Student.java
 * Represents a single student with basic details.
 * Humanised version for readability and learning purposes.
 */

public class Student {

    private int id;
    private String name;
    private int age;
    private String department;

    // Constructor to initialize student details
    public Student(int id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Display student details
    public void display() {
        System.out.println(id + "\t" + name + "\t" + age + "\t" + department);
    }
}
