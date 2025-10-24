package devices;

public class SmartLock implements Device {
    private boolean locked = true;
    
    @Override
    public void turnOn() {
        if (locked) {
            locked = false;
            System.out.println("Smart Lock UNLOCKED.");
        } else {
            System.out.println("Smart Lock is already unlocked.");
        }
    }
    
    public void turnOff() {
        if (!locked) {
            locked = true;
            System.out.println("Smart Lock LOCKED.");
        } else {
            System.out.println("Smart Lock is already locked.");
        }
    }
    
    public void set(int code) {
        System.out.println("Access code updated: " + code);
    }
    
    public void ecoMode() {
        System.out.println("Smart Lock auto-lock enabled (eco mode)");
    }
}

