package ebs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class psuccess implements ActionListener {
    psuccess() {
        ImageIcon image = new ImageIcon("C:\\Users\\harsh\\Downloads\\like\\picsart.png");
        JLabel l2 = new JLabel();
        l2.setBounds(-50, 0, 800, 837);
        l2.setIcon(image);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(1600, 1600);
        panel.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        JLabel label = new JLabel();
        label.setText("PAYMENT SUCCESS");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Lucida Calligraphy", Font.BOLD, 65));
        label.setBounds(650, 300, 900, 80);
        panel.add(label);
        JButton n = new JButton("EXIT");
        n.setBounds(900, 500, 100, 50);
        n.addActionListener(this);
        panel.add(n);
        panel.add(l2);
        frame.setVisible(true);
        panel.setBackground(Color.BLACK);
    }

    public static void main(String[] args) {
        new psuccess();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new login();
    }
}
