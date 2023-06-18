package com.chiara.andria.progetto.w3.runner;

import com.chiara.andria.progetto.w3.model.FireAlarm;
import com.chiara.andria.progetto.w3.observer.FireAlarmControlCenter;
import com.chiara.andria.progetto.w3.observer.FileAlarmSensor;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FireAlarmSystemRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FileAlarmSensor sensor = new FileAlarmSensor();
        FireAlarmControlCenter controlCenter = new FireAlarmControlCenter("Centro di Controllo 1");

        sensor.registerObserver(controlCenter);

        sensor.detectFire();

        sensor.resetFireDetection();

        sensor.detectFire();
    }
}
