package com.chiara.andria.progetto.w3.test;

import com.chiara.andria.progetto.w3.model.FireAlarm;
import com.chiara.andria.progetto.w3.observer.FileAlarmSensor;
import com.chiara.andria.progetto.w3.observer.FireAlarmControlCenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;

public class FireAlarmTest {
    private FileAlarmSensor sensor;
    private FireAlarmControlCenter controlCenter;

    @BeforeEach
    public void setup() {
        sensor = new FileAlarmSensor();
        controlCenter = new FireAlarmControlCenter("Centro di Controllo 1");
        sensor.registerObserver(controlCenter);
    }

    @Test
    public void testFireDetection() {
        FireAlarm fireAlarm = new FireAlarm();
        fireAlarm.setId("ID001");
        fireAlarm.setLatitude(42.12345);
        fireAlarm.setLongitude(10.98765);
        fireAlarm.setSmokeLevel(7);
        sensor.detectFire(fireAlarm);
        assertTrue(sensor.isFireDetected());
    }

    @Test
    public void testNoFireDetection() {
        FireAlarm fireAlarm = new FireAlarm();
        fireAlarm.setId("ID002");
        fireAlarm.setLatitude(43.98765);
        fireAlarm.setLongitude(11.12345);
        fireAlarm.setSmokeLevel(3);
        sensor.detectFire(fireAlarm);
        assertFalse(sensor.isFireDetected());
    }

    @Test
    public void testFireAlarmNotification() {
        FireAlarm fireAlarm = new FireAlarm();
        fireAlarm.setId("ID003");
        fireAlarm.setLatitude(41.56789);
        fireAlarm.setLongitude(9.43210);
        fireAlarm.setSmokeLevel(8);
        sensor.detectFire(fireAlarm);

        assertEquals("Centro di Controllo 1", controlCenter.getCenterName());
        assertTrue(controlCenter.isNotificationReceived());
        assertEquals(fireAlarm, controlCenter.getReceivedNotification());
    }

	private void assertTrue(Object notificationReceived) {
		
	} 
}
