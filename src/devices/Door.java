package devices;

import observer.DeviceSubject;

public class Door implements Device {
    private boolean locked = true;
    private boolean open = false;
    private DeviceSubject subject = new DeviceSubject();

    public void turnOn() {
        locked = false;
        if (!locked) {
            open = true;
            System.out.println("Door opened. Welcome home!");
            subject.notifyObservers("Door", "opened", true);
        } else {
            System.out.println("Door is locked. Cannot open.");
        }
    }

    public void turnOff() {
        locked = true;
        System.out.println("Door locked.");
        subject.notifyObservers("Door", "closed", true);
    }
    
    public void set(int x){
        System.out.println("Door closed for" + x + "munites");
    }
    
    public void ecoMode(){
        System.out.println("Door ecomode activated.");
    }
    
    public DeviceSubject getSubject() {
        return subject;
    }
}

