package devices;

public class AirConditioner implements Device {
    private boolean isOn = false;
    private int temperature = 24;
    
    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("Air Conditioner is ON. Temperature: " + temperature + "°C");
        } else {
            System.out.println("Air Conditioner is already ON.");
        }
    }
    
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("Air Conditioner is OFF.");
        } else {
            System.out.println("Air Conditioner is already OFF.");
        }
    }
    
    public void set(int temp) {
        temperature = temp;
        System.out.println("Air Conditioner temperature set to " + temp + "°C");
    }
    
    public void ecoMode() {
        temperature = 26;
        System.out.println("Air Conditioner eco mode: 26°C (energy saving)");
    }
}

