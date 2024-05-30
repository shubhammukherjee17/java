import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Main extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8;
    JButton btn1, btn2;
    Main() {
        setVisible(true);
        setSize(700, 700);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Information");
        l1 = new JLabel("Student Information");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Poppins", Font.BOLD, 20));
        l2 = new JLabel("Roll No:");
        l3 = new JLabel("Name:");
        l4 = new JLabel("Course:");
        l5 = new JLabel("Address:");
        l6 = new JLabel("Phone No:");
        l7 = new JLabel("Email:");
        l8 = new JLabel("DOB:");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        l1.setBounds(100, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230, 200, 30);
        l7.setBounds(80, 270, 200, 30);
        l8.setBounds(80, 310, 200, 30);
        tf1.setBounds(300, 70, 200, 30);
        tf2.setBounds(300, 110, 200, 30);
        tf3.setBounds(300, 150, 200, 30);
        tf4.setBounds(300, 190, 200, 30);
        tf5.setBounds(300, 230, 200, 30);
        tf6.setBounds(300, 270, 200, 30);
        tf7.setBounds(300, 310, 200, 30);
        tf8.setBounds(300, 310, 200, 30);
        btn1.setBounds(50, 350, 100, 30);
        btn2.setBounds(170, 350, 100, 30);
        add(l1);
        add(l2);
        add(tf1);
        add(l3);
        add(tf2);
        add(l4);
        add(tf3);
        add(l5);
        add(tf4);
        add(l6);
        add(tf5);
        add(l7);
        add(tf6);
        add(l8);
        add(tf7);
        add(tf8);
        add(btn1);
        add(btn2);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            int x = 0;
            String s1 = tf1.getText();
            String s2 = tf2.getText();
            String s3 = tf3.getText();
            String s4 = tf4.getText();
            String s5 = tf5.getText();
            String s6 = tf6.getText();
            String s7 = tf7.getText();
            String s8 = tf8.getText();
//            if (s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("") || s6.equals("") || s7.equals("") || s8.equals("")) {
//                JOptionPane.showMessageDialog(btn1, "Please enter all the fields");
//            } else {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "root");
                    PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?)");
                    ps.setString(1, s1);
                    ps.setString(2, s2);
                    ps.setString(3, s3);
                    ps.setString(4, s4);
                    ps.setString(5, s5);
                    ps.setString(6, s6);
                    ps.setString(7, s7);
                    ps.setString(8, s8);
                    x = ps.executeUpdate();
                    if (x > 0) {
                        JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            //}
        } else {
            tf1.setText("");
            tf2.setText("");
            tf3.setText("");
            tf4.setText("");
            tf5.setText("");
            tf6.setText("");
            tf7.setText("");
            tf8.setText("");
        }
    }
    public static void main(String args[]) {
        new Main();
    }
}