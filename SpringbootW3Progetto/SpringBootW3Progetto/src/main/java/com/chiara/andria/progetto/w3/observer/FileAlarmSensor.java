package com.chiara.andria.progetto.w3.observer;

import java.util.ArrayList;
import java.util.List;

import com.chiara.andria.progetto.w3.model.FireAlarm;

public class FileAlarmSensor implements FireAlarmSubject {
    private List<FireAlarmObserver> observers;
    private boolean isFireDetected;
    
    public FileAlarmSensor() {
        observers = new ArrayList<>();
        isFireDetected = false;
    }

    @Override
    public void registerObserver(FireAlarmObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(FireAlarmObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(FireAlarm fireAlarm) {
        for (FireAlarmObserver observer : observers) {
            observer.update(fireAlarm);
        }
    }

    public void detectFire() {
        if (!isFireDetected) {
            FireAlarm fireAlarm = new FireAlarm();
            fireAlarm.setId("ID001");
            fireAlarm.setLatitude(42.12345);
            fireAlarm.setLongitude(10.98765);
            fireAlarm.setSmokeLevel(7);
            
            isFireDetected = true;
            
            notifyObservers(fireAlarm);
        }
    }
    
    public void resetFireDetection() {
        isFireDetected = false;
    }
    
    public boolean isFireDetected() {
        return isFireDetected;
    }

	public void detectFire(FireAlarm fireAlarm) {
		
	}
}
