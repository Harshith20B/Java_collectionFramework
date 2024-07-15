package lab;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.*;

class Student{
    String usn,name,cat,addr;
    int age;
    double sg1,sg2,sg3,sg4,cgpa;
    Student(String name,String usn,String cat,String addr,int age,double sg1,double sg2,double sg3,double sg4){
        this.name = name;
        this.usn = usn;
        this.cat=cat;
        this.addr=addr;
        this.sg1=sg1;
        this.sg2=sg2;
        this.sg3=sg3;
    }
    public String toString(){
        return (name+" "+usn+" "+cat+" "+addr+" "+cgpa);
    }
}
public class pr implements ActionListener{
    static JFrame f1 = new JFrame("Student Info");
    static JLabel label1 = new JLabel("Enter Name");
    static JLabel label2 = new JLabel("Enter USN");
    static JLabel label3 = new JLabel("Enter Address");
    static JLabel label4 = new JLabel("Enter Category");
    static JLabel label5 = new JLabel("Enter Age");
    static JLabel label6 = new JLabel("Enter sgpa1");
    static JLabel label7 = new JLabel("Enter sgpa2");
    static JLabel label8 = new JLabel("Enter sgpa3");
    static JLabel label9 = new JLabel("Enter sgpa4");

    static JTextField tname = new JTextField(20);
    static JTextField tusn = new JTextField(20);
    static JTextField taddr = new JTextField(20);
    static JTextField tcat = new JTextField(20);
    static JTextField tage = new JTextField(20);
    static JTextField sgpa1 = new JTextField(20);
    static JTextField sgpa2 = new JTextField(20);
    static JTextField sgpa3 = new JTextField(20);
    static JTextField sgpa4 = new JTextField(20);
    static JButton submit = new JButton("Submit");
    static JButton done = new JButton("Done");
    static JButton display = new JButton("Display");
    static ArrayList<Student> AA = new ArrayList<Student>();
    public static void main(String args[]){
        f1.setSize(400,600);
        f1.setLayout(new GridLayout(0,2));
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f1.add(label1);
        f1.add(tname);
        f1.add(label2);
        f1.add(tusn);
        f1.add(label3);
        f1.add(taddr);
        f1.add(label4);
        f1.add(tcat);
        f1.add(label5);
        f1.add(tage);
        f1.add(label6);
        f1.add(sgpa1);
        f1.add(label7);
        f1.add(sgpa2);
        f1.add(label8);
        f1.add(sgpa3);
        f1.add(label9);
        f1.add(sgpa4);
        f1.add(submit);
        f1.add(done);
        f1.add(display);

        submit.addActionListener(new pr());
        done.addActionListener(new pr());
        display.addActionListener(new pr());
        
        f1.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == submit){
            int age = Integer.parseInt(tage.getText());
            if(age<18 || age>30){
                JOptionPane.showMessageDialog(f1,"Enter valid age between 18 and 30");
            }else{
                check(1,sgpa1);
                check(2,sgpa2);
                check(3,sgpa3);
                check(4,sgpa4);
            }
        }else if(e.getSource() == done){
            double s1 = Double.parseDouble(sgpa1.getText());
            double s2 = Double.parseDouble(sgpa2.getText());
            double s3 = Double.parseDouble(sgpa3.getText());
            double s4 = Double.parseDouble(sgpa4.getText());
            double cg = (s1 + s2 + s3 + s4) / 4;
            Student ob = new Student(tname.getText(), tusn.getText(), taddr.getText(), tcat.getText(), Integer.parseInt(tage.getText()), s1, s2, s3, s4);
            ob.cgpa = cg;
            AA.add(ob);
            JOptionPane.showMessageDialog(f1, "Student information added successfully.");
            clearFields();
        }else if(e.getSource() == display){
            f1.setVisible(false);
            JFrame f2 = new JFrame("Display Window");
            f2.setSize(500,500);
            f2.setLayout(new GridLayout(1,1));
            JTextArea info = new JTextArea(20,20);
            f2.setVisible(true);
            JScrollPane scrollPane = new JScrollPane(info);
            f2.add(scrollPane);
            StringBuilder studentInfo = new StringBuilder();
            for (Student ob1 : AA) {
                studentInfo.append(ob1.toString());
            }
            info.setText(studentInfo.toString());
        }
    }
    void check(int i,JTextField sgpa){
        double sgpaVal = Double.parseDouble(sgpa.getText());
        if(sgpaVal<0 || sgpaVal>10){
            JOptionPane.showMessageDialog(f1,"Enter valis sgpa Value");
        }
        // double sgpaValue = Double.parseDouble(sgpa.getText());
        // if (sgpaValue < 0 || sgpaValue > 10) {
        //     String temp = JOptionPane.showInputDialog(null, "Semester " + i + " Enter valid SGPA (0 to 10):");
        //     sgpa.setText(temp);
        // }
    }
    void clearFields(){
        tname.setText("");
        tusn.setText("");
        taddr.setText("");
        tcat.setText("");
        tage.setText("");
        sgpa1.setText("");
        sgpa2.setText("");
        sgpa3.setText("");
        sgpa4.setText("");
    }
}