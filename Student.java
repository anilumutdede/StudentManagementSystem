public class Student {
    private String studentID; // Öğrenci ID'si
    private String name;      // Öğrencinin adı
    private int age;          // Öğrencinin yaşı
    private double grade;     // Öğrencinin notu

    // Yapıcı metod (Başlatıcı)
    public Student(String studentID, String name, int age, double grade) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getter ve Setter metodları (Bilgi al ve değiştir)
    public String getStudentID() { return studentID; }
    public void setStudentID(String studentID) { this.studentID = studentID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public double getGrade() { return grade; }
    public void setGrade(double grade) { this.grade = grade; }
}
