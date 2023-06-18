package com.chiara.andria.progetto.w3.observer;

import com.chiara.andria.progetto.w3.model.FireAlarm;

public interface FireAlarmSubject {

    void registerObserver(FireAlarmObserver observer);
    void removeObserver(FireAlarmObserver observer);
    void notifyObservers(FireAlarm fireAlarm);
}
