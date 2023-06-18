package com.chiara.andria.progetto.w3.security;

public class SecurityManager {
    private static SecurityManager instance;
    private boolean accessGranted;
    
    private SecurityManager() {
        accessGranted = false;
    }
    
    public static SecurityManager getInstance() {
        if (instance == null) {
            instance = new SecurityManager();
        }
        return instance;
    }
    
    public boolean isAccessGranted() {
        return accessGranted;
    }
    
    public void grantAccess() {
        accessGranted = true;
    }
    
    public void revokeAccess() {
        accessGranted = false;
    }
}
