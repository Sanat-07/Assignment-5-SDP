package devices;

public class SmartBlinds implements Device {
    private int openLevel = 0;
    
    @Override
    public void turnOn() {
        openLevel = 100;
        System.out.println("Smart Blinds are FULLY OPEN (100%)");
    }
    
    public void turnOff() {
        openLevel = 0;
        System.out.println("Smart Blinds are FULLY CLOSED (0%)");
    }
    
    public void set(int level) {
        openLevel = level;
        System.out.println("Smart Blinds set to " + level + "% open");
    }
    
    public void ecoMode() {
        openLevel = 50;
        System.out.println("Smart Blinds eco mode: 50% open (natural light)");
    }
}

