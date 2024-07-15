package lab.lab2;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.*;
public class TextPanel extends JPanel{
    JTextArea textArea = new JTextArea();
    public TextPanel(){
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea),BorderLayout.CENTER);
    }
    public void appendText(String string){
        textArea.append(string);
    }
    public static void main(String args[]){
        new TextPanel();
    }
}
