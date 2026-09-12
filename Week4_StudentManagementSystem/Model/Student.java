package Model;

public class Student {

    private int id;
    private String name;
    private String branch;
    private double marks;
    private String email;

    // Constructor
    public Student(int id, String name, String branch, double marks, String email) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.marks = marks;
        this.email = email;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBranch() {
        return branch;
    }

    public double getMarks() {
        return marks;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Display student
    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Branch: " + branch +
               ", Marks: " + marks +
               ", Email: " + email;
    }
}