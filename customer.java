package ebs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;


public class customer implements ActionListener {
    public customer() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(1600, 1600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        panel.setLayout(null);

        JLabel p = new JLabel("CUSTOMER DETAILS");
        p.setBounds(530, 50, 700, 60);
        p.setForeground(Color.white);
        p.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 55));
        panel.add(p);
        JLabel label = new JLabel("CustomerName");
        label.setBounds(650, 200, 100, 25);
        label.setForeground(Color.white);
        panel.add(label);
        JTextField usertext = new JTextField();
        usertext.setBounds(790, 200, 165, 25);
        panel.add(usertext);
        JLabel label1 = new JLabel("Location");
        label1.setBounds(650, 250, 80, 25);
        label1.setForeground(Color.white);
        panel.add(label1);
        JTextField usertext1 = new JTextField();
        usertext1.setBounds(790, 250, 165, 25);
        panel.add(usertext1);
        JLabel label2 = new JLabel("ID");
        label2.setBounds(650, 300, 80, 25);
        panel.add(label2);
        label2.setForeground(Color.white);
        JTextField usertext2 = new JTextField();
        usertext2.setBounds(790, 300, 165, 25);
        panel.add(usertext2);
        JLabel label3 = new JLabel("Type");
        label3.setBounds(650, 350, 80, 25);
        panel.add(label3);
        label3.setForeground(Color.white);
        JTextField usertext3 = new JTextField();
        usertext3.setBounds(790, 350, 165, 25);
        panel.add(usertext3);
        JLabel label4 = new JLabel("units");
        label4.setBounds(650, 400, 100, 25);
        panel.add(label4);
        label4.setForeground(Color.white);
        JTextField usertext4 = new JTextField();
        usertext4.setBounds(790, 400, 165, 25);
        panel.add(usertext4);

        JButton button2 = new JButton("next");
        button2.setBounds(760, 520, 80, 45);
        button2.addActionListener(this);
        panel.add(button2);
        frame.setVisible(true);
        panel.setBackground(Color.BLACK);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
                            "admin");
                    String ins = "insert into customerdetails(NAME,LOCATION,ID,TYPE,UNITS)values(?,?,?,?,?)";
                    PreparedStatement st = con.prepareStatement(ins);
                    st.setString(1, usertext.getText());
                    st.setString(2, usertext1.getText());
                    st.setString(3, usertext2.getText());
                    st.setString(4, usertext3.getText());
                    st.setString(5, usertext4.getText());

                    st.executeUpdate();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws SQLException,
            ClassNotFoundException {
        new customer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new billdetails();

    }
}
