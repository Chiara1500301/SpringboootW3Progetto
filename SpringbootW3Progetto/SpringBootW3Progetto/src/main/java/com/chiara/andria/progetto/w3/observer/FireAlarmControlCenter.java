package com.chiara.andria.progetto.w3.observer;

import com.chiara.andria.progetto.w3.model.FireAlarm;

public class FireAlarmControlCenter  implements FireAlarmObserver  {
    private String centerName;
    
    public FireAlarmControlCenter(String centerName) {
        this.centerName = centerName;
    }

    @Override
    public void update(FireAlarm fireAlarm) {
        System.out.println("Notifica ricevuta dal centro di controllo " + centerName);
        System.out.println("Informazioni sulla sonda:");
        System.out.println("ID: " + fireAlarm.getId());
        System.out.println("Latitudine: " + fireAlarm.getLatitude());
        System.out.println("Longitudine: " + fireAlarm.getLongitude());
        System.out.println("Livello di fumo rilevato: " + fireAlarm.getSmokeLevel());
        
        if (fireAlarm.getSmokeLevel() > 5) {
            activateAlarm();
            notifyPersonnel();
        }
    }
    
    private void activateAlarm() {
        System.out.println("Allarme attivato presso il centro di controllo " + centerName);
    }
    
    private void notifyPersonnel() {
        System.out.println("Avviso del personale competente presso il centro di controllo " + centerName);
    }

	public Object getCenterName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object isNotificationReceived() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getReceivedNotification() {
		// TODO Auto-generated method stub
		return null;
	}
}
