package com.chiara.andria.progetto.w3.model;

public class FireAlarmNotification {
    private String id;
    private double latitude;
    private double longitude;
    private double smokeLevel;

    public FireAlarmNotification(FireAlarm fireAlarm) {
        this.id = fireAlarm.getId();
        this.latitude = fireAlarm.getLatitude();
        this.longitude = fireAlarm.getLongitude();
        this.smokeLevel = fireAlarm.getSmokeLevel();
    }

    public FireAlarmNotification(String id2, double latitude2, double longitude2, double smokeLevel2) {
	}

	public String getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getSmokeLevel() {
        return smokeLevel;
    }
}
