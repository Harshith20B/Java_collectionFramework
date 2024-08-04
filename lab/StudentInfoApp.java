import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class StudentInfoApp extends JFrame implements ActionListener {
	private JTextField nameField, usnField, ageField, addressField, sgpa1Field, sgpa2Field,
	sgpa3Field, sgpa4Field, categoryField;
	private JButton computeButton, doneButton, displayButton;
	private JTextArea displayArea;
	private ArrayList<Student> studentList;
	public StudentInfoApp() {
		studentList = new ArrayList<>();
		setTitle("Student Information");
		setLayout(new GridLayout(12, 2));
		add(new JLabel("Name:"));
		nameField = new JTextField();
		add(nameField);
		add(new JLabel("USN:"));
		usnField = new JTextField();
		add(usnField);
		add(new JLabel("Age:"));
		ageField = new JTextField();
		add(ageField);
		add(new JLabel("Address:"));
		addressField = new JTextField();
		add(addressField);
		add(new JLabel("SGPA 1:"));
		sgpa1Field = new JTextField();
		add(sgpa1Field);
		add(new JLabel("SGPA 2:"));
		sgpa2Field = new JTextField();
		add(sgpa2Field);
		add(new JLabel("SGPA 3:"));
		sgpa3Field = new JTextField();
		add(sgpa3Field);
		add(new JLabel("SGPA 4:"));
		sgpa4Field = new JTextField();
		add(sgpa4Field);
		add(new JLabel("Category:"));
		categoryField = new JTextField();
		add(categoryField);
		computeButton = new JButton("Compute");
		computeButton.addActionListener(this);
		add(computeButton);
		doneButton = new JButton("Done");
		doneButton.addActionListener(this);
		add(doneButton);
		displayButton = new JButton("Display");
		displayButton.addActionListener(this);
		add(displayButton);
		displayArea = new JTextArea();
		add(new JScrollPane(displayArea));
		setSize(400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == computeButton) {
			computeCGPA();
		} else if (e.getSource() == doneButton) {
			addStudent();
		} else if (e.getSource() == displayButton) {
			displayStudents();
		}
	}
	private void computeCGPA() {
		try {
			double sgpa1 = Double.parseDouble(sgpa1Field.getText());
			double sgpa2 = Double.parseDouble(sgpa2Field.getText());
			double sgpa3 = Double.parseDouble(sgpa3Field.getText());
			double sgpa4 = Double.parseDouble(sgpa4Field.getText());
			double cgpa = (sgpa1 + sgpa2 + sgpa3 + sgpa4) / 4.0;
			JOptionPane.showMessageDialog(this, "CGPA: " + cgpa);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Please enter valid SGPA values.");
		}
	}
	private void addStudent() {
		String name = nameField.getText();
		String usn = usnField.getText();
		String ageText = ageField.getText();
		String address = addressField.getText();
		String category = categoryField.getText();
		if (name.isEmpty() || usn.isEmpty() || ageText.isEmpty() || address.isEmpty() ||
		category.isEmpty()) {
			JOptionPane.showMessageDialog(this, "All fields must be filled out.");
			return;
		}
		try {
			int age = Integer.parseInt(ageText);
			double sgpa1 = Double.parseDouble(sgpa1Field.getText());
			double sgpa2 = Double.parseDouble(sgpa2Field.getText());
			double sgpa3 = Double.parseDouble(sgpa3Field.getText());
			double sgpa4 = Double.parseDouble(sgpa4Field.getText());
			Student student = new Student(name, usn, age, address, sgpa1, sgpa2, sgpa3, sgpa4,
			category);
			studentList.add(student);
			JOptionPane.showMessageDialog(this, "Student details added.");
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Please enter valid numerical values for age andSGPA.");
		}
	}
	private void displayStudents() {
		StringBuilder displayText = new StringBuilder();
		for (Student student : studentList) {
			displayText.append(student).append("\n");
		}
		displayArea.setText(displayText.toString());
	}
	public static void main(String[] args) {
		new StudentInfoApp();
	}
}
class Student {
	private String name, usn, address, category;
	private int age;
	private double sgpa1, sgpa2, sgpa3, sgpa4;
	public Student(String name, String usn, int age, String address, double sgpa1, double sgpa2,
	double sgpa3, double sgpa4, String category) {
		this.name = name;
		this.usn = usn;
		this.age = age;
		this.address = address;
		this.sgpa1 = sgpa1;
		this.sgpa2 = sgpa2;
		this.sgpa3 = sgpa3;
		this.sgpa4 = sgpa4;
		this.category = category;
	}
	@Override
	public String toString() {
        return "Name: " + name + ", USN: " + usn + ", Age: " + age + ", Address: " + address + ", SGPA1:"
        + sgpa1 + ", SGPA2: " + sgpa2 + ", SGPA3: " + sgpa3 + ", SGPA4: " + sgpa4 + ", Category: " +
        category;
    }
}
