import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class prog8 extends JFrame {
	// JDBC URL, username, password
	private static final String URL = "jdbc:mysql://localhost:3306/CustomerDB";
	private static final String USER = "root";
	private static final String PASSWORD = "Harsha@20";
	// GUI components
	private JTextField custNameField, stateField, creditLimitField;
	private JButton insertButton, displayButton;
	public prog8() {
		setTitle("Customer Database");
		setSize(400, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 2));
		// Create and add GUI components
		add(new JLabel("Customer Name:"));
		custNameField = new JTextField();
		add(custNameField);
		add(new JLabel("State:"));
		stateField = new JTextField();
		add(stateField);
		add(new JLabel("Credit Limit:"));
		creditLimitField = new JTextField();
		add(creditLimitField);
		insertButton = new JButton("Insert");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertCustomer();
			}
		});
		add(insertButton);
		displayButton = new JButton("Display");
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayCustomers();
			}
		});
		add(displayButton);
	}
	private void insertCustomer() {
		String custName = custNameField.getText();
		String state = stateField.getText();
		String creditLimitStr = creditLimitField.getText();
		double creditLimit = Double.parseDouble(creditLimitStr);
		try (Connection connection = DriverManager.getConnection(URL, USER,PASSWORD)) {
			String query = "INSERT INTO Customer (CustName, State, Credit_Limit)VALUES (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, custName);
			preparedStatement.setString(2, state);
			preparedStatement.setDouble(3, creditLimit);
			preparedStatement.executeUpdate();
			JOptionPane.showMessageDialog(this, "Customer inserted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error inserting customer",
			"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void displayCustomers() {
		try (Connection connection = DriverManager.getConnection(URL, USER,PASSWORD)) {
			String query = "SELECT * FROM Customer";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			StringBuilder results = new StringBuilder();
			while (resultSet.next()) {
				int custNo = resultSet.getInt("CustNo");
				String custName = resultSet.getString("CustName");
				String state = resultSet.getString("State");
				double creditLimit = resultSet.getDouble("Credit_Limit");
				results.append("CustNo: ").append(custNo)
				.append(", CustName: ").append(custName)
				.append(", State: ").append(state)
				.append(", Credit Limit: ").append(creditLimit).append("\n");
			}
			JOptionPane.showMessageDialog(this, results.toString(), "CustomerList", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error displaying customers",
			"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				new prog8().setVisible(true);
//			}
//		});
		new prog8().setVisible(true);
	}
}