package org.example.project;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel {
    private JTextField gameIdField, gameTitleField;
    private JTable gameTable;

    public GamePanel(DatabaseHandler dbHandler) {
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Game ID:"));
        gameIdField = new JTextField();
        inputPanel.add(gameIdField);

        inputPanel.add(new JLabel("Game Title:"));
        gameTitleField = new JTextField();
        inputPanel.add(gameTitleField);

        JButton addButton = new JButton("Insert Game");
        addButton.addActionListener(e -> {
            dbHandler.insertGame(
                    Integer.parseInt(gameIdField.getText()),
                    gameTitleField.getText()
            );
            loadGameTable(dbHandler);
        });
        inputPanel.add(addButton);

        add(inputPanel, BorderLayout.NORTH);

        // Game Table
        gameTable = new JTable();
        loadGameTable(dbHandler);
        add(new JScrollPane(gameTable), BorderLayout.CENTER);
    }

    private void loadGameTable(DatabaseHandler dbHandler) {
        List<Object[]> gameData = dbHandler.getAllGames();
        String[] columnNames = {"Game ID", "Game Title"};
        Object[][] data = gameData.toArray(new Object[0][]);
        gameTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}
