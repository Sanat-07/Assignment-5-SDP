public class MusicSystem implements Device {
    private boolean isPlaying = false;
    private int volume = 50;


    @Override

    public void turnOn() {
        if (!isPlaying) {
            isPlaying = true;
            System.out.println("Music system is playing music.");
        } else {
            System.out.println("Music is already playing.");
        }
    }

    public void turnOff() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Music system is stopped.");
        } else {
            System.out.println("Music is already stopped.");
        }
    }
    public void set(int v) {
        volume = v;
        System.out.println("Music volume set to " + volume + "%");
    }
    public void ecoMode() {
        System.out.println("Eco mode is on");
    }
}