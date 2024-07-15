package lab;
import java.util.HashMap;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class pr implements ActionListener{
    JFrame frame;
    JTextField phoneField, customerIdField, itemIdField, quantityField, totalCostField;
    JButton checkCustomerButton, addItemButton, printButton;
    JTextArea itemDetailsArea;
    JRadioButton discount30, discount10;
    ButtonGroup discountGroup;

    private HashMap<String, Integer> customerData;
    private HashMap<Integer, String> itemData;
    private HashMap<Integer, Double> itemPrices;
    public pr(){
        frame = new JFrame("Customer Purchase App");
        frame.setSize(400,300);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        customerData.put("8947398752",121);
        customerData.put("9327432235",122);
        customerData.put("7321783792",123);


        

    }
}

