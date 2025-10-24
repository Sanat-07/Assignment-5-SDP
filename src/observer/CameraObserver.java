package observer;

import devices.SecurityCamera;

public class CameraObserver implements DeviceObserver {
    private SecurityCamera camera;
    
    public CameraObserver(SecurityCamera camera) {
        this.camera = camera;
    }
    
    @Override
    public void update(String deviceName, String event, Object data) {
        if (deviceName.equals("Door") && event.equals("opened")) {
            System.out.println("[Observer] Door opened detected! Activating security camera...");
            camera.turnOn();
        }
    }
}

