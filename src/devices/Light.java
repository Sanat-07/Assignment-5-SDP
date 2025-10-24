package devices;

import observer.DeviceSubject;

public class Light implements Device {
    private boolean isOn = false;
    private int brightness = 100;
    private DeviceSubject subject = new DeviceSubject();
    
    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            brightness = 100;
            System.out.println("Light is ON.");
        } else {
            System.out.println("Light is already ON.");
        }
    }

    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Light is OFF.");
        } else {
            System.out.println("Light is already OFF.");
        }
    }
    
    public void ecoMode() {
        System.out.println("Eco mode is on ");
    }
    
    public void set(int x) {
        brightness = x;
        if (x <= 40) {
            System.out.println("Light set to dim mode (brightness: " + x + "%)");
        } else {
            System.out.println("Set brightness " + x + "%");
        }
    }
    
    public DeviceSubject getSubject() {
        return subject;
    }
}

