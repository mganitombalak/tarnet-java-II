package com.tarnet.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    public MainForm() throws HeadlessException {
        this.setSize(800, 600);
        this.setTitle("Tarnet Desktop");

        JPanel panel = new JPanel();

        JButton btnClick = new JButton("Click me!");

//        class AnonymousBtnClick implements ActionListener{
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null,"OK");
//            }
//        }


        btnClick.addActionListener(new ActionListener() { // Anonymous Class
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"OK");
            }
        });

        panel.add(btnClick);
        this.setLocation(300, 300);
        this.getContentPane().add(BorderLayout.CENTER, panel);
        this.setVisible(true);
    }
}
