package org.example.project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainPanel extends JPanel {
    private JTextField firstNameField, lastNameField, addressField, postalCodeField, provinceField, phoneNumberField;
    private JTextField playerIdField, gameIdField, gameTitleField;
    private JTable dataTable;

    public MainPanel(DatabaseHandler dbHandler) {
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        // Player fields
        inputPanel.add(new JLabel("Player ID:"), createGbc(0, row));
        playerIdField = new JTextField();
        inputPanel.add(playerIdField, createGbc(1, row++));

        inputPanel.add(new JLabel("First Name:"), createGbc(0, row));
        firstNameField = new JTextField();
        inputPanel.add(firstNameField, createGbc(1, row++));

        inputPanel.add(new JLabel("Last Name:"), createGbc(0, row));
        lastNameField = new JTextField();
        inputPanel.add(lastNameField, createGbc(1, row++));

        inputPanel.add(new JLabel("Address:"), createGbc(0, row));
        addressField = new JTextField();
        inputPanel.add(addressField, createGbc(1, row++));

        inputPanel.add(new JLabel("Postal Code:"), createGbc(0, row));
        postalCodeField = new JTextField();
        inputPanel.add(postalCodeField, createGbc(1, row++));

        inputPanel.add(new JLabel("Province:"), createGbc(0, row));
        provinceField = new JTextField();
        inputPanel.add(provinceField, createGbc(1, row++));

        inputPanel.add(new JLabel("Phone Number:"), createGbc(0, row));
        phoneNumberField = new JTextField();
        inputPanel.add(phoneNumberField, createGbc(1, row++));

        // Game fields
        inputPanel.add(new JLabel("Game ID:"), createGbc(0, row));
        gameIdField = new JTextField();
        inputPanel.add(gameIdField, createGbc(1, row++));

        inputPanel.add(new JLabel("Game Title:"), createGbc(0, row));
        gameTitleField = new JTextField();
        inputPanel.add(gameTitleField, createGbc(1, row++));

        // Buttons
        JButton insertButton = new JButton("Insert Player");
        insertButton.addActionListener(e -> {
            dbHandler.insertPlayer(
                    firstNameField.getText(),
                    lastNameField.getText(),
                    addressField.getText(),
                    postalCodeField.getText(),
                    provinceField.getText(),
                    phoneNumberField.getText()
            );
            loadTable(dbHandler);
        });

        JButton updateButton = new JButton("Update Player");
        updateButton.addActionListener(e -> {
            Label someInputField = new Label();
            String input = someInputField.getText().trim();
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Input cannot be empty");
                return;
            }
            try {
                int number = Integer.parseInt(input);
                // Proceed with the parsed number
            } catch (NumberFormatException i) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
            }

            int playerId = Integer.parseInt(playerIdField.getText());
            dbHandler.updatePlayer(
                    playerId,
                    firstNameField.getText(),
                    lastNameField.getText(),
                    addressField.getText(),
                    postalCodeField.getText(),
                    provinceField.getText(),
                    phoneNumberField.getText()
            );
            loadTable(dbHandler);
        });

        JButton deleteButton = new JButton("Delete Player");
        deleteButton.addActionListener(e -> {
            int playerId = Integer.parseInt(playerIdField.getText());
            dbHandler.deletePlayer(playerId);
            loadTable(dbHandler);
        });

        inputPanel.add(insertButton, createGbc(0, row++));
        inputPanel.add(updateButton, createGbc(1, row++));
        inputPanel.add(deleteButton, createGbc(1, row++));

        add(inputPanel, BorderLayout.NORTH);

        // Table for displaying players and games
        dataTable = new JTable();
        loadTable(dbHandler);
        add(new JScrollPane(dataTable), BorderLayout.CENTER);
    }

    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        return gbc;
    }

    private void loadTable(DatabaseHandler dbHandler) {
        List<Object[]> playerData = dbHandler.getAllPlayers();
        List<Object[]> gameData = dbHandler.getAllGames();

        String[] columnNames = {"ID", "First Name", "Last Name", "Address", "Postal Code", "Province", "Phone", "Game Title"};
        Object[][] data = new Object[playerData.size() + gameData.size()][];

        int rowIndex = 0;
        for (Object[] player : playerData) {
            data[rowIndex++] = player;
        }
        for (Object[] game : gameData) {
            data[rowIndex++] = game;
        }

        dataTable.setModel(new DefaultTableModel(data, columnNames));
    }
}
