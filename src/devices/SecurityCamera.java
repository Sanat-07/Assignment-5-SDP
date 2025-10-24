package devices;

public class SecurityCamera implements Device {
    private int time;
    @Override
    public void turnOn() {
        System.out.println("Security camera is recording.");
    }

    public void turnOff() {
        System.out.println("Security camera deactivated.");
    }
    public void set(int x) {
        time = x;
        System.out.println("Security camera is set for" + x + "minutes.");

    }
    public void ecoMode() {
        System.out.println("Eco mode is on");
    }
}

