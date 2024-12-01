package org.example.project;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Player and Game Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        DatabaseHandler dbHandler = new DatabaseHandler();
        add(new ManagementPanel(dbHandler));

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
