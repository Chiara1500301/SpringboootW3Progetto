package com.chiara.andria.progetto.w3.controller;

import com.chiara.andria.progetto.w3.model.FireAlarm;
import com.chiara.andria.progetto.w3.model.FireAlarmNotification;
import com.chiara.andria.progetto.w3.utility.HttpClient;

public class FireAlarmController {
	   public void handleFireAlarm(FireAlarm fireAlarm) {
	        if (fireAlarm.getSmokeLevel() > 5) {
	            FireAlarmNotification notification = new FireAlarmNotification(fireAlarm);

	            String url = "http://host/alarm?idsonda=" + fireAlarm.getId()
	                    + "&lat=" + fireAlarm.getLatitude()
	                    + "&lon=" + fireAlarm.getLongitude()
	                    + "&smokelevel=" + fireAlarm.getSmokeLevel();

	            HttpClient.sendHttpRequest(url);

	            System.out.println("Allarme attivato! Notifica inviata al centro di controllo.");
	            System.out.println("Informazioni sulla sonda:");
	            System.out.println("ID: " + fireAlarm.getId());
	            System.out.println("Latitudine: " + fireAlarm.getLatitude());
	            System.out.println("Longitudine: " + fireAlarm.getLongitude());
	            System.out.println("Livello di fumo rilevato: " + fireAlarm.getSmokeLevel());
	        } else {
	            System.out.println("Livello di fumo inferiore o uguale a 5. Nessuna azione richiesta.");
	        }
	    }

}
