public class HomeAutomationFacade {
    private Device smartLight;
    private Device smartMusic;
    private Device smartThermostat;
    private Device smartDoor;
    private Device smartCamera;

    public HomeAutomationFacade(Light light, MusicSystem musicSystem, Thermostat thermostat, SecurityCamera camera, Door door) {
        smartLight = createSmartDevice(light);
        smartMusic = createSmartDevice(musicSystem);
        smartThermostat = createSmartDevice(thermostat);
        smartDoor = createSmartDevice(door);
        smartCamera = createSmartDevice(camera);
    }

    private Device createSmartDevice(Device baseDevice) {
        return new RemoteAccessDecorator(
                new VoiceControlDecorator(
                        new EnergySavingDecorator(baseDevice)
                )
        );
    }

    public void activateNightMode() {
        System.out.println("\n--- Activating Night Mode ---");
        smartLight.turnOff();
        if (smartThermostat instanceof Thermostat) {
            ((Thermostat) smartThermostat).ecoMode();
        }
        smartCamera.turnOn();
        smartDoor.turnOff();
    }

    public void startPartyMode() {
        System.out.println("\n--- Starting Party Mode ---");
        smartLight.turnOn();
        System.out.println("Lights set to dim mode.");
        smartMusic.turnOn();
        if (smartMusic instanceof MusicSystem) {
            ((MusicSystem) smartMusic).set(80);
        }
    }

    public void leaveHome() {
        System.out.println("\n--- Leaving Home ---");
        smartLight.turnOff();
        smartMusic.turnOff();
        smartCamera.turnOn();
        smartDoor.turnOff();
        System.out.println("All systems secured.");
    }
}