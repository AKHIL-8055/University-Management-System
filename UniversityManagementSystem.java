import java.awt.*;
import java.awt.event.*;

class Student {
    String name;
    String course;
    String grade;
    double fee;

    public Student(String name, String course, String grade, double fee) {
        this.name = name;
        this.course = course;
        this.grade = grade;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Course: " + course + ", Grade: " + grade + ", Fee: $" + fee;
    }
}

public class UniversityManagementSystem extends Frame implements ActionListener {

    TextField studentNameField, courseField, gradeField, feeField;
    TextArea outputArea;
    java.util.List<Student> studentList;

    public UniversityManagementSystem() {
        studentList = new java.util.ArrayList<>();

        Label nameLabel = new Label("Student Name:");
        Label courseLabel = new Label("Course:");
        Label gradeLabel = new Label("Grade:");
        Label feeLabel = new Label("Fee:");

        studentNameField = new TextField();
        courseField = new TextField();
        gradeField = new TextField();
        feeField = new TextField();

        Button addButton = new Button("Add Student");
        Button viewButton = new Button("View Students");

        outputArea = new TextArea();

        setLayout(new FlowLayout());

        add(nameLabel);
        add(studentNameField);
        add(courseLabel);
        add(courseField);
        add(gradeLabel);
        add(gradeField);
        add(feeLabel);
        add(feeField);
        add(addButton);
        add(viewButton);
        add(outputArea);

        addButton.addActionListener(this);
        viewButton.addActionListener(this);

        setTitle("University Management System");
        setSize(400, 300);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();

        if (actionCommand.equals("Add Student")) {
            String studentName = studentNameField.getText();
            String course = courseField.getText();
            String grade = gradeField.getText();
            double fee = Double.parseDouble(feeField.getText());

            Student student = new Student(studentName, course, grade, fee);
            studentList.add(student);

            outputArea.append("Student added: " + student + "\n");
            clearFields();
        } else if (actionCommand.equals("View Students")) {
            outputArea.append("List of students:\n");
            for (Student student : studentList) {
                outputArea.append(student + "\n");
            }
        }
    }

    private void clearFields() {
        studentNameField.setText("");
        courseField.setText("");
        gradeField.setText("");
        feeField.setText("");
    }

    public static void main(String[] args) {
        new UniversityManagementSystem();
    }
}
