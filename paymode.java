package ebs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class paymode implements ActionListener {
    JButton pp, ptm, gpay;

    paymode() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(1600, 1600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        JLabel label = new JLabel("Modes Of Payment");
        label.setForeground(Color.GRAY);
        label.setFont(new Font("Serif", Font.BOLD, 45));
        label.setBounds(600, 100, 400, 45);
        panel.add(label);
        ImageIcon image = new ImageIcon("C:\\Users\\harsh\\Desktop\\payment\\pp.png");
        ImageIcon image1 = new ImageIcon("C:\\Users\\harsh\\Desktop\\payment\\gg.png");
        ImageIcon image2 = new ImageIcon("C:\\Users\\harsh\\Desktop\\payment\\paytm.png");

        pp = new JButton(image);
        pp.setBounds(650, 200, 250, 50);
        panel.add(pp);
        ptm = new JButton(image1);
        ptm.setBounds(650, 270, 250, 50);
        panel.add(ptm);
        gpay = new JButton(image2);
        gpay.setBounds(650, 340, 250, 50);
        pp.addActionListener(this);
        ptm.addActionListener(this);
        gpay.addActionListener(this);
        panel.add(gpay);
        panel.setBackground(Color.black);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new paymode();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new psuccess();
    }
}

