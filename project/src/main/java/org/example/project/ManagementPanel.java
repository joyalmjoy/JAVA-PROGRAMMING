package org.example.project;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ManagementPanel extends JPanel {
    private JTextField firstNameField, lastNameField, addressField, postalCodeField, provinceField, phoneNumberField;
    private JTextField gameIdField, gameTitleField;
    private JTable playerTable, gameTable;

    public ManagementPanel(DatabaseHandler dbHandler) {
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(8, 2));
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

        inputPanel.add(new JLabel("Game ID:"));
        gameIdField = new JTextField();
        inputPanel.add(gameIdField);

        inputPanel.add(new JLabel("Game Title:"));
        gameTitleField = new JTextField();
        inputPanel.add(gameTitleField);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3));
        JButton insertPlayerButton = new JButton("Insert Player");
        insertPlayerButton.addActionListener(e -> {
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
        buttonPanel.add(insertPlayerButton);

        JButton updatePlayerButton = new JButton("Update Player");
        updatePlayerButton.addActionListener(e -> {
            dbHandler.updatePlayer(
                    Integer.parseInt(gameIdField.getText()), // Game ID field reused for player ID
                    firstNameField.getText(),
                    lastNameField.getText(),
                    addressField.getText(),
                    postalCodeField.getText(),
                    provinceField.getText(),
                    phoneNumberField.getText()
            );
            loadPlayerTable(dbHandler);
        });
        buttonPanel.add(updatePlayerButton);

        JButton deletePlayerButton = new JButton("Delete Player");
        deletePlayerButton.addActionListener(e -> {
            dbHandler.deletePlayer(Integer.parseInt(gameIdField.getText())); // Game ID field reused for player ID
            loadPlayerTable(dbHandler);
        });
        buttonPanel.add(deletePlayerButton);

        JButton insertGameButton = new JButton("Insert Game");
        insertGameButton.addActionListener(e -> {
            dbHandler.insertGame(
                    Integer.parseInt(gameIdField.getText()),
                    gameTitleField.getText()
            );
            loadGameTable(dbHandler);
        });
        buttonPanel.add(insertGameButton);

        JButton updateGameButton = new JButton("Update Game");
        updateGameButton.addActionListener(e -> {
            dbHandler.updateGame(
                    Integer.parseInt(gameIdField.getText()),
                    gameTitleField.getText()
            );
            loadGameTable(dbHandler);
        });
        buttonPanel.add(updateGameButton);

        JButton deleteGameButton = new JButton("Delete Game");
        deleteGameButton.addActionListener(e -> {
            dbHandler.deleteGame(Integer.parseInt(gameIdField.getText()));
            loadGameTable(dbHandler);
        });
        buttonPanel.add(deleteGameButton);

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        // Data Display Panel
        JPanel dataPanel = new JPanel(new GridLayout(2, 1));
        playerTable = new JTable();
        loadPlayerTable(dbHandler);
        dataPanel.add(new JScrollPane(playerTable));

        gameTable = new JTable();
        loadGameTable(dbHandler);
        dataPanel.add(new JScrollPane(gameTable));

        add(dataPanel, BorderLayout.CENTER);
    }

    private void loadPlayerTable(DatabaseHandler dbHandler) {
        List<Object[]> playerData = dbHandler.getAllPlayers();
        String[] columnNames = {"Player ID", "First Name", "Last Name", "Address", "Postal Code", "Province", "Phone Number"};
        Object[][] data = playerData.toArray(new Object[0][]);
        playerTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    private void loadGameTable(DatabaseHandler dbHandler) {
        List<Object[]> gameData = dbHandler.getAllGames();
        String[] columnNames = {"Game ID", "Game Title"};
        Object[][] data = gameData.toArray(new Object[0][]);
        gameTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}
