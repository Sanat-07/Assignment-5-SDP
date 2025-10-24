package devices;

public class Door implements Device {
    private boolean locked = true;
    private boolean open = false;

    public void turnOn() {
        locked = false;
        if (!locked) {
            open = true;
            System.out.println("Door opened. Welcome home!");
        } else {
            System.out.println("Door is locked. Cannot open.");
        }
    }

    public void turnOff() {
        locked = true;
        System.out.println("Door locked.");
    }
    public void set(int x){
        System.out.println("Door closed for" + x + "munites");
    }
    public void ecoMode(){
        System.out.println("Door ecomode activated.");
    }
}

