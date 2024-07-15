package lab.lab2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MyFrame extends JFrame {
    // TextPanel textpanel = new TextPanel();
    JTextArea textArea = new JTextArea();
    // FormPanel Formpanel = new FormPanel();
    // ToolBar jtool = new ToolBar();
    JButton button = new JButton("Click me");

    public MyFrame() {
        super("My new Frame");
        setVisible(true);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add components to the frame
        add(textArea, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Button was clicked!\n");
            }
        });
    }

    public static void main(String[] args) {
        // Create an instance of MyFrame
        new MyFrame();
    }
}
