package devices;

import observer.DeviceSubject;

public class Thermostat implements Device {
    private int temperature = 22;
    private DeviceSubject subject = new DeviceSubject();

    @Override
    public void turnOn() {
        System.out.println("Thermostat set to comfortable temperature (" + temperature + "°C).");
    }
    
    public void turnOff() {
        System.out.println("Thermostat is off");
    }

    public void set(int temp) {
        temperature = temp;
        System.out.println("Thermostat now set to " + temp + "°C.");
        subject.notifyObservers("Thermostat", "temperature_changed", temp);
    }

    public void ecoMode() {
        temperature = 18;
        System.out.println("Thermostat set to eco mode (" + temperature + "°C).");
    }
    
    public DeviceSubject getSubject() {
        return subject;
    }
}

