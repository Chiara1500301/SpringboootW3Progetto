package com.chiara.andria.progetto.w3.repository;

import com.chiara.andria.progetto.w3.model.FireAlarmNotification;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FireAlarmNotificationRepository {
    private Connection connection;

    public FireAlarmNotificationRepository() {
        String url = "jdbc:postgresql://localhost:5432/sistema_incendio";
        String username = "postgres";
        String password = "root";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<FireAlarmNotification> getAllFireAlarmNotifications() {
        List<FireAlarmNotification> notifications = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM fire_alarm_notifications");

            while (resultSet.next()) {
                String id = resultSet.getString("id");
                double latitude = resultSet.getDouble("latitude");
                double longitude = resultSet.getDouble("longitude");
                double smokeLevel = resultSet.getDouble("smoke_level");

                FireAlarmNotification notification = new FireAlarmNotification(id, latitude, longitude, smokeLevel);
                notifications.add(notification);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return notifications;
    }

    public void saveFireAlarmNotification(FireAlarmNotification notification) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO fire_alarm_notifications (id, latitude, longitude, smoke_level) VALUES (?, ?, ?, ?)");
            statement.setString(1, notification.getId());
            statement.setDouble(2, notification.getLatitude());
            statement.setDouble(3, notification.getLongitude());
            statement.setDouble(4, notification.getSmokeLevel());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
