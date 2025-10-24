package devices;

public class RobotVacuum implements Device {
    private boolean cleaning = false;
    private int powerLevel = 50;
    
    @Override
    public void turnOn() {
        if (!cleaning) {
            cleaning = true;
            System.out.println("Robot Vacuum started cleaning.");
        } else {
            System.out.println("Robot Vacuum is already cleaning.");
        }
    }
    
    public void turnOff() {
        if (cleaning) {
            cleaning = false;
            System.out.println("Robot Vacuum stopped and returned to dock.");
        } else {
            System.out.println("Robot Vacuum is already stopped.");
        }
    }
    
    public void set(int power) {
        powerLevel = power;
        System.out.println("Robot Vacuum power set to " + power + "%");
    }
    
    public void ecoMode() {
        powerLevel = 30;
        System.out.println("Robot Vacuum eco mode: 30% power (quiet cleaning)");
    }
}

