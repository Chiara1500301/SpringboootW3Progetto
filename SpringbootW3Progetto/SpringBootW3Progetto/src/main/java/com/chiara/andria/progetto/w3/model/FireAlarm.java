package com.chiara.andria.progetto.w3.model;

public class FireAlarm {
    private String id;
    private double latitude;
    private double longitude;
    private int smokeLevel;
    
    public FireAlarm() {
    }
    
    public FireAlarm(String id, double latitude, double longitude, int smokeLevel) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.smokeLevel = smokeLevel;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public double getLatitude() {
        return latitude;
    }
    
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    public double getLongitude() {
        return longitude;
    }
    
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
    public int getSmokeLevel() {
        return smokeLevel;
    }
    
    public void setSmokeLevel(int smokeLevel) {
        this.smokeLevel = smokeLevel;
    }
}
