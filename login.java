package ebs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class login implements ActionListener {
    JButton s, c;

    login() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(1600, 1600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        JLabel x = new JLabel("CUSTOMER LOGIN");
        x.setBounds(420, 100, 1100, 60);
        x.setForeground(Color.gray);
        x.setFont(new Font("Lucida Calligraphy", Font.PLAIN, 55));
        panel.add(x);
        JLabel label = new JLabel("METER NUMBER");
        label.setBounds(500, 250, 300, 40);
        label.setForeground(Color.white);
        label.setFont(new Font("Georgia", Font.PLAIN, 25));
        panel.add(label);
        JTextField usertext = new JTextField();
        usertext.setBounds(750, 250, 165, 30);
        panel.add(usertext);
        JLabel label1 = new JLabel("USER NAME");
        label1.setBounds(500, 320, 300, 40);
        label1.setForeground(Color.white);
        label1.setFont(new Font("Georgia", Font.PLAIN, 25));
        panel.add(label1);
        JTextField usertext1 = new JTextField();
        usertext1.setBounds(750, 320, 165, 30);
        panel.add(usertext1);
        JLabel label2 = new JLabel("PASSWORD");
        label2.setBounds(500, 390, 300, 30);
        label2.setForeground(Color.white);
        label2.setFont(new Font("Georgia", Font.PLAIN, 25));
        panel.add(label2);
        JTextField usertext2 = new JTextField();
        usertext2.setBounds(750, 390, 165, 30);
        panel.add(usertext2);
        c = new JButton("CLEAR");
        c.setBounds(6500, 550, 80, 40);
        panel.add(c);
        s = new JButton("LOGIN");
        s.setBounds(700, 550, 80, 40);
        panel.add(s);
        s.addActionListener(this);
        frame.setVisible(true);
        panel.setBackground(Color.BLACK);

        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
                            "system", "admin");
                    String ins = "insert into logindetails (METERNO,USERNAME,PASSWORD) values (?,?,?)";
                    PreparedStatement st = conn.prepareStatement(ins);
                    st.setString(1, usertext.getText());
                    st.setString(2, usertext1.getText());
                    st.setString(3, usertext2.getText());
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
        new login();
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        new customer();
    }
}
