package lab;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class CustomerPurchaseApp implements ActionListener {
    private JFrame frame;
    private JTextField phoneField, customerIdField, itemIdField, quantityField, totalCostField;
    private JButton checkCustomerButton, addItemButton, printButton;
    private JTextArea itemDetailsArea;
    private JRadioButton discount30, discount10;
    private ButtonGroup discountGroup;

    private HashMap<String, Integer> customerData;
    private HashMap<Integer, String> itemData;
    private HashMap<Integer, Double> itemPrices;

    public CustomerPurchaseApp() {
        frame = new JFrame("Customer Purchase App");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        phoneField = new JTextField(10);
        customerIdField = new JTextField(10);
        itemIdField = new JTextField(5);
        quantityField = new JTextField(5);
        totalCostField = new JTextField(20);
        totalCostField.setEditable(false);

        checkCustomerButton = new JButton("Check Customer");
        addItemButton = new JButton("Add Item");
        printButton = new JButton("Print");

        itemDetailsArea = new JTextArea(10, 30);
        itemDetailsArea.setEditable(false);

        discount30 = new JRadioButton("Discount 30%");
        discount10 = new JRadioButton("Discount 10%");
        discountGroup = new ButtonGroup();
        discountGroup.add(discount30);
        discountGroup.add(discount10);

        frame.add(new JLabel("Customer Phone:"));
        frame.add(phoneField);
        frame.add(checkCustomerButton);
        frame.add(new JLabel("Customer ID:"));
        frame.add(customerIdField);
        frame.add(new JLabel("#1 APPLE 150rs/Kg   #2 Orange 60rs/kg"));
        frame.add(new JLabel("Enter Item Number:"));
        frame.add(itemIdField);
        frame.add(new JLabel("Quantity (kg):"));
        frame.add(quantityField);
        frame.add(discount30);
        frame.add(discount10);
        frame.add(addItemButton);
        frame.add(new JScrollPane(itemDetailsArea));
        frame.add(printButton);

        checkCustomerButton.addActionListener(this);
        addItemButton.addActionListener(this);
        printButton.addActionListener(this);

        customerData = new HashMap<>();
        itemData = new HashMap<>();
        itemPrices = new HashMap<>();

        // Adding sample customer data
        customerData.put("9741278570", 121);
        customerData.put("9900726035", 122);
        customerData.put("9900001111", 123);

        // Adding sample item data
        itemData.put(1, "Apple");
        itemData.put(2, "Orange");
        itemPrices.put(1, 150.0);
        itemPrices.put(2, 60.0);

        String uname = JOptionPane.showInputDialog(null, "Enter USERNAME=");
        String psw = JOptionPane.showInputDialog(null, "Enter PASSWORD=");

        if (uname.equals("msrit123") && psw.equals("ise123")) {
            JOptionPane.showMessageDialog(null, "LOGIN VALID");
            frame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "LOGIN INVALID");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new CustomerPurchaseApp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == checkCustomerButton) {
            String phone = phoneField.getText();
            if (customerData.containsKey(phone)) {
                JOptionPane.showMessageDialog(null, "Existing Customer ID: " + customerData.get(phone));
                customerIdField.setText(Integer.toString(customerData.get(phone)));
            } else {
                int newCustomerId = 124 + customerData.size();
                customerData.put(phone, newCustomerId);
                JOptionPane.showMessageDialog(null, "New Customer, ID: " + newCustomerId);
                customerIdField.setText(Integer.toString(newCustomerId));
            }
        } else if (e.getSource() == addItemButton) {
            int itemId;
            int quantity;
            try {
                itemId = Integer.parseInt(itemIdField.getText());
                quantity = Integer.parseInt(quantityField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid item number or quantity.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (itemData.containsKey(itemId)) {
                String itemName = itemData.get(itemId);
                double itemPrice = itemPrices.get(itemId);
                double totalCost = itemPrice * quantity;

                if (discount30.isSelected()) {
                    totalCost *= 0.7;
                } else if (discount10.isSelected()) {
                    totalCost *= 0.9;
                }

                itemDetailsArea.append(itemName + " - Quantity: " + quantity + "kg - Total Cost: " + totalCost + "\n");
                totalCostField.setText("Total: " + totalCost);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid item ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == printButton) {
            JOptionPane.showMessageDialog(null, "Item Details:\n" + itemDetailsArea.getText(), "Receipt", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
