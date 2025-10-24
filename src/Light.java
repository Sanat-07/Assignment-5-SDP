public class Light implements Device {
    private boolean isOn = false;
    @Override
    public void turnOn() {
        if (!isOn) {
            isOn = true;
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
        System.out.println("Set brightness " + x);

    }
}