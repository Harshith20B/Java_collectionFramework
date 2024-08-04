import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class RepresentativeApp extends JFrame {
	private JTextField repNoField, repNameField, stateField, commissionField,
	rateField;
	private JButton insertButton, displayButton;
	private JTextArea displayArea;
	// Database connection details
	private static final String URL = "jdbc:mysql://localhost:3306/CustomerDB"; //Update with your DB name
	private static final String USER = "root"; // Update with your DB username
	private static final String PASSWORD = "Harsha@20"; // Update with your DB password
	public RepresentativeApp() {
		setTitle("Representative Management");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(11, 2));
		// Create components
		JLabel repNoLabel = new JLabel("Rep No:");
		repNoField = new JTextField();
		JLabel repNameLabel = new JLabel("Rep Name:");
		repNameField = new JTextField();
		JLabel stateLabel = new JLabel("State:");
		stateField = new JTextField();
		JLabel commissionLabel = new JLabel("Commission:");
		commissionField = new JTextField();
		JLabel rateLabel = new JLabel("Rate:");
		rateField = new JTextField();
		insertButton = new JButton("Insert");
		displayButton = new JButton("Display");
		displayArea = new JTextArea();
		//displayArea.setPreferredSize(new Dimension(400, 200));
		displayArea.setEditable(false);
		// Add components to frame
		add(repNoLabel);
		add(repNoField);
		add(repNameLabel);
		add(repNameField);
		add(stateLabel);
		add(stateField);
		add(commissionLabel);
		add(commissionField);
		add(rateLabel);
		add(rateField);
		add(insertButton);
		add(displayButton);
		add(new JScrollPane(displayArea));
		// Button listeners
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertRepresentative();
			}
		});
		displayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				displayRepresentatives();
			}
		});
	}
	private void insertRepresentative() {
		String repNo = repNoField.getText();
		String repName = repNameField.getText();
		String state = stateField.getText();
		String commission = commissionField.getText();
		String rate = rateField.getText();
		try (Connection connection = DriverManager.getConnection(URL, USER,PASSWORD)) {
			String sql = "INSERT INTO Representative (RepNo, RepName, State,Commission, Rate) VALUES (?, ?, ?, ?, ?)";
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setInt(1, Integer.parseInt(repNo));
				pstmt.setString(2, repName);
				pstmt.setString(3, state);
				pstmt.setBigDecimal(4, new java.math.BigDecimal(commission));
				pstmt.setBigDecimal(5, new java.math.BigDecimal(rate));
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(this, "Representative addedsuccessfully!");
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void displayRepresentatives() {
		try (Connection connection = DriverManager.getConnection(URL, USER,PASSWORD);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM Representative")) {
			StringBuilder sb = new StringBuilder();
			while (rs.next()) {
				sb.append("Rep No: ").append(rs.getInt("RepNo")).append("\n").append("Rep Name:").append(rs.getString("RepName")).append("\n")
				.append("State: ").append(rs.getString("State")).append("\n")
				.append("Commission:").append(rs.getBigDecimal("Commission")).append("\n")
				.append("Rate: ").append(rs.getBigDecimal("Rate")).append("\n")
				.append("--------------------------\n");
			}
			displayArea.setText(sb.toString());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(),
			"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				new RepresentativeApp().setVisible(true);
//			}
//		});
		new RepresentativeApp().setVisible(true);
	}
}
