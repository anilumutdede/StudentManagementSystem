import java.util.ArrayList;

public interface StudentManager {
    void addStudent(Student student);
    void removeStudent(String studentID);
    void updateStudent(String studentID, String name, int age, double grade);
    ArrayList<Student> displayAllStudents();
    double calculateAverageGrade(); // Ortalama not hesaplama
}
