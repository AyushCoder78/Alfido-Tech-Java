import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Student {
    String name;
    String rollNumber;

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }
}

public class StudentManagementSystem extends JFrame {

    private List<Student> students;
    private JTextField nameField, rollNumberField;
    private JTextArea displayArea;

    public StudentManagementSystem() {
        students = new ArrayList<>();

        setTitle("Student Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel rollNumberLabel = new JLabel("Roll Number:");
        rollNumberField = new JTextField();

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editStudent();
            }
        });

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        displayArea = new JTextArea();
        displayArea.setEditable(false);

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(rollNumberLabel);
        panel.add(rollNumberField);
        panel.add(addButton);
        panel.add(editButton);
        panel.add(deleteButton);

        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addStudent() {
        String name = nameField.getText();
        String rollNumber = rollNumberField.getText();

        if (!name.isEmpty() && !rollNumber.isEmpty()) {
            Student student = new Student(name, rollNumber);
            students.add(student);
            displayStudents();
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Name and Roll Number cannot be empty.");
        }
    }

    private void editStudent() {
        // Implement edit functionality here
    }

    private void deleteStudent() {
        // Implement delete functionality here
    }

    private void displayStudents() {
        displayArea.setText("");
        for (Student student : students) {
            displayArea.append("Name: " + student.name + ", Roll Number: " + student.rollNumber + "\n");
        }
    }

    private void clearFields() {
        nameField.setText("");
        rollNumberField.setText("");
    }

    public static void main(String[] args) {
        new StudentManagementSystem();
    }
}
