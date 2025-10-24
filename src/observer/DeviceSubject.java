package observer;

import java.util.ArrayList;
import java.util.List;

public class DeviceSubject {
    private List<DeviceObserver> observers = new ArrayList<>();
    
    public void attach(DeviceObserver observer) {
        observers.add(observer);
    }
    
    public void detach(DeviceObserver observer) {
        observers.remove(observer);
    }
    
    public void notifyObservers(String deviceName, String event, Object data) {
        for (DeviceObserver observer : observers) {
            observer.update(deviceName, event, data);
        }
    }
}

