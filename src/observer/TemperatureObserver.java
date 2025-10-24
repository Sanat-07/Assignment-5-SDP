package observer;

public class TemperatureObserver implements DeviceObserver {
    
    @Override
    public void update(String deviceName, String event, Object data) {
        if (deviceName.equals("Thermostat") && event.equals("temperature_changed")) {
            int temperature = (int) data;
            if (temperature > 30) {
                System.out.println("[Observer] WARNING! Temperature is too high: " + temperature + "°C");
                System.out.println("[Notification] 📱 Alert: Your home temperature exceeded 30°C!");
            }
        }
    }
}

