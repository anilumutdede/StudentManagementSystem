package src;

import java.sql.*;
import java.util.ArrayList;

public class StudentManagerImpl implements StudentManager {

    private Connection connect() {
        String url = "jdbc:sqlite:students.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
        return conn;
    }


    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO students(studentID, name, age, grade) VALUES(?, ?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, student.getStudentID());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());
            pstmt.setDouble(4, student.getGrade());
            pstmt.executeUpdate();
            System.out.println("Student added!");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    @Override
    public void removeStudent(String studentID) {
        String sql = "DELETE FROM students WHERE studentID = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, studentID);
            pstmt.executeUpdate();
            System.out.println("Student removed!");
        } catch (SQLException e) {
            System.out.println("Error removing student: " + e.getMessage());
        }
    }

    @Override
    public void updateStudent(String studentID, String name, int age, double grade) {
        String sql = "UPDATE students SET name = ?, age = ?, grade = ? WHERE studentID = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setDouble(3, grade);
            pstmt.setString(4, studentID);
            pstmt.executeUpdate();
            System.out.println("Student updated!");
        } catch (SQLException e) {
            System.out.println("Error updating student: " + e.getMessage());
        }
    }

    @Override
    public ArrayList<Student> displayAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(rs.getString("studentID"),
                        rs.getString("name"), rs.getInt("age"), rs.getDouble("grade")));
            }
        } catch (SQLException e) {
            System.out.println("Error listing students: " + e.getMessage());
        }
        return students;
    }

    @Override
    public double calculateAverageGrade() {
        double avg = 0;
        String sql = "SELECT AVG(grade) AS avgGrade FROM students";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                avg = rs.getDouble("avgGrade");
            }
        } catch (SQLException e) {
            System.out.println("Error calculating average grade: " + e.getMessage());
        }
        return avg;
    }
}
