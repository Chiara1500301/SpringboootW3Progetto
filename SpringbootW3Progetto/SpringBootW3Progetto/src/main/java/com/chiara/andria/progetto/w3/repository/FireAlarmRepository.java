package com.chiara.andria.progetto.w3.repository;

import com.chiara.andria.progetto.w3.model.FireAlarm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FireAlarmRepository {
    private Connection connection;

    public FireAlarmRepository() {
        String url = "jdbc:postgresql://localhost:5432/sistema_incendio";
        String username = "postgres";
        String password = "root";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<FireAlarm> getAllFireAlarms() {
        List<FireAlarm> fireAlarms = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM fire_alarms");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                double latitude = resultSet.getDouble("latitude");
                double longitude = resultSet.getDouble("longitude");
                int smokeLevel = resultSet.getInt("smoke_level");

                FireAlarm fireAlarm = new FireAlarm(id, latitude, longitude, smokeLevel);
                fireAlarms.add(fireAlarm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fireAlarms;
    }

    public void saveFireAlarm(FireAlarm fireAlarm) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO fire_alarms (id, latitude, longitude, smoke_level) VALUES (?, ?, ?, ?)");
            statement.setString(1, fireAlarm.getId());
            statement.setDouble(2, fireAlarm.getLatitude());
            statement.setDouble(3, fireAlarm.getLongitude());
            statement.setInt(4, fireAlarm.getSmokeLevel());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFireAlarm(FireAlarm fireAlarm) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE fire_alarms SET latitude = ?, longitude = ?, smoke_level = ? WHERE id = ?");
            statement.setDouble(1, fireAlarm.getLatitude());
            statement.setDouble(2, fireAlarm.getLongitude());
            statement.setInt(3, fireAlarm.getSmokeLevel());
            statement.setString(4, fireAlarm.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFireAlarm(String id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM fire_alarms WHERE id = ?");
            statement.setString(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
