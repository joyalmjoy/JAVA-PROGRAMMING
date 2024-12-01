package org.example.project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {
    private Connection connection;

    public DatabaseHandler() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@199.212.26.208:1521:SQLD",
                    "COMP228_F24_soh_45",
                    "password"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Player Methods
    public void insertPlayer(String firstName, String lastName, String address, String postalCode, String province, String phoneNumber) {
        String query = "INSERT INTO JOYAL_JOY_PLAYER (PLAYER_ID, FIRST_NAME, LAST_NAME, ADDRESS, POSTAL_CODE, PROVINCE, PHONE_NUMBER) " +
                "VALUES (JOYAL_JOY_PLAYER_SEQ.nextval, ?, ?, ?, ?, ?, ?)";
        executeUpdate(query, firstName, lastName, address, postalCode, province, phoneNumber);
    }

    public void updatePlayer(int playerId, String firstName, String lastName, String address, String postalCode, String province, String phoneNumber) {
        String query = "UPDATE JOYAL_JOY_PLAYER SET FIRST_NAME = ?, LAST_NAME = ?, ADDRESS = ?, POSTAL_CODE = ?, PROVINCE = ?, PHONE_NUMBER = ? " +
                "WHERE PLAYER_ID = ?";
        executeUpdate(query, firstName, lastName, address, postalCode, province, phoneNumber, playerId);
    }

    public void deletePlayer(int playerId) {
        String query = "DELETE FROM JOYAL_JOY_PLAYER WHERE PLAYER_ID = ?";
        executeUpdate(query, playerId);
    }

    // Game Methods
    public void insertGame(int gameId, String gameTitle) {
        String query = "INSERT INTO JOYAL_JOY_GAME (GAME_ID, GAME_TITLE) VALUES (?, ?)";
        executeUpdate(query, gameId, gameTitle);
    }

    public void updateGame(int gameId, String gameTitle) {
        String query = "UPDATE JOYAL_JOY_GAME SET GAME_TITLE = ? WHERE GAME_ID = ?";
        executeUpdate(query, gameTitle, gameId);
    }

    public void deleteGame(int gameId) {
        String query = "DELETE FROM JOYAL_JOY_GAME WHERE GAME_ID = ?";
        executeUpdate(query, gameId);
    }

    // Fetch Data
    public List<Object[]> getAllPlayers() {
        String query = "SELECT PLAYER_ID, FIRST_NAME, LAST_NAME, ADDRESS, POSTAL_CODE, PROVINCE, PHONE_NUMBER FROM JOYAL_JOY_PLAYER";
        return fetchData(query);
    }

    public List<Object[]> getAllGames() {
        String query = "SELECT GAME_ID, GAME_TITLE FROM JOYAL_JOY_GAME";
        return fetchData(query);
    }

    private List<Object[]> fetchData(String query) {
        List<Object[]> dataList = new ArrayList<>();
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                dataList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    private void executeUpdate(String query, Object... params) {
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
