package observer;

import devices.Light;

public class LightObserver implements DeviceObserver {
    private Light light;
    
    public LightObserver(Light light) {
        this.light = light;
    }
    
    @Override
    public void update(String deviceName, String event, Object data) {
        if (deviceName.equals("MusicSystem") && event.equals("turned_on")) {
            System.out.println("[Observer] Music started! Setting light to dim mode...");
            light.set(30);
        }
    }
}

