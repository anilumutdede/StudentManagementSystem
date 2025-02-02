

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StudentGUI {
    private StudentManagerImpl manager;

    public StudentGUI() {
        manager = new StudentManagerImpl();
        JFrame frame = new JFrame("Student Management System");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(6, 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Bileşenleri ekle ve buton olaylarını tanımla
    }

    public static void main(String[] args) {
        new StudentGUI();
    }

    private class StudentManagerImpl {
    }
}
