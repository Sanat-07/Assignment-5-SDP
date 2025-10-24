package devices;

import observer.DeviceSubject;

public class MusicSystem implements Device {
    private boolean isPlaying = false;
    private int volume = 50;
    private DeviceSubject subject = new DeviceSubject();

    @Override
    public void turnOn() {
        if (!isPlaying) {
            isPlaying = true;
            System.out.println("Music system is playing music.");
            subject.notifyObservers("MusicSystem", "turned_on", true);
        } else {
            System.out.println("Music is already playing.");
        }
    }

    public void turnOff() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Music system is stopped.");
            subject.notifyObservers("MusicSystem", "turned_off", true);
        } else {
            System.out.println("Music is already stopped.");
        }
    }
    
    public void set(int v) {
        volume = v;
        System.out.println("Music volume set to " + volume + "%");
    }
    
    public void ecoMode() {
        System.out.println("Eco mode is on");
    }
    
    public DeviceSubject getSubject() {
        return subject;
    }
}

