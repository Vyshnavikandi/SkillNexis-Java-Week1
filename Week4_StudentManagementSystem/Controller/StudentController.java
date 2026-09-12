package Controller;

import Database.DBConnection;
import Model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentController {

    // ADD STUDENT
    public void addStudent(Student student) {

        String sql = "INSERT INTO students (id, name, branch, marks, email) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getBranch());
            statement.setDouble(4, student.getMarks());
            statement.setString(5, student.getEmail());

            statement.executeUpdate();

            System.out.println("Student added successfully!");

            connection.close();

        } catch (Exception e) {
            System.out.println("Error adding student.");
            e.printStackTrace();
        }
    }

    // VIEW STUDENTS
    public ArrayList<Student> viewStudents() {

        ArrayList<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                int id = result.getInt("id");
                String name = result.getString("name");
                String branch = result.getString("branch");
                double marks = result.getDouble("marks");
                String email = result.getString("email");

                Student student = new Student(
                        id,
                        name,
                        branch,
                        marks,
                        email
                );

                students.add(student);
            }

            connection.close();

        } catch (Exception e) {
            System.out.println("Error viewing students.");
            e.printStackTrace();
        }

        return students;
    }

    // UPDATE STUDENT
    public void updateStudent(Student student) {

        String sql = "UPDATE students SET name=?, branch=?, marks=?, email=? WHERE id=?";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(1, student.getName());
            statement.setString(2, student.getBranch());
            statement.setDouble(3, student.getMarks());
            statement.setString(4, student.getEmail());
            statement.setInt(5, student.getId());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student ID not found.");
            }

            connection.close();

        } catch (Exception e) {
            System.out.println("Error updating student.");
            e.printStackTrace();
        }
    }

    // DELETE STUDENT
    public void deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id=?";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student ID not found.");
            }

            connection.close();

        } catch (Exception e) {
            System.out.println("Error deleting student.");
            e.printStackTrace();
        }
    }
}