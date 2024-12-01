package org.example.project;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PlayerPanel extends JPanel {
    private JTextField firstNameField, lastNameField, addressField, postalCodeField, provinceField, phoneNumberField;
    private JTable playerTable;

    public PlayerPanel(DatabaseHandler dbHandler) {
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(7, 2));
        inputPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        inputPanel.add(firstNameField);

        inputPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        inputPanel.add(lastNameField);

        inputPanel.add(new JLabel("Address:"));
        addressField = new JTextField();
        inputPanel.add(addressField);

        inputPanel.add(new JLabel("Postal Code:"));
        postalCodeField = new JTextField();
        inputPanel.add(postalCodeField);

        inputPanel.add(new JLabel("Province:"));
        provinceField = new JTextField();
        inputPanel.add(provinceField);

        inputPanel.add(new JLabel("Phone Number:"));
        phoneNumberField = new JTextField();
        inputPanel.add(phoneNumberField);

        JButton addButton = new JButton("Insert Player");
        addButton.addActionListener(e -> {
            dbHandler.insertPlayer(
                    firstNameField.getText(),
                    lastNameField.getText(),
                    addressField.getText(),
                    postalCodeField.getText(),
                    provinceField.getText(),
                    phoneNumberField.getText()
            );
            loadPlayerTable(dbHandler);
        });
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // Player Table
        playerTable = new JTable();
        loadPlayerTable(dbHandler);
        add(new JScrollPane(playerTable), BorderLayout.CENTER);
    }

    private void loadPlayerTable(DatabaseHandler dbHandler) {
        List<Object[]> playerData = dbHandler.getAllPlayers();
        String[] columnNames = {"Player ID", "First Name", "Last Name", "Address", "Postal Code", "Province", "Phone Number"};
        Object[][] data = playerData.toArray(new Object[0][]);
        playerTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}
