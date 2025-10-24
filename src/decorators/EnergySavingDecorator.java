package decorators;

import devices.Device;

public class EnergySavingDecorator extends DeviceDecorator {
    public EnergySavingDecorator(Device decoratedDevice) {
        super(decoratedDevice);
    }

    @Override
    public void turnOn() {
        decoratedDevice.turnOn();
        enableEnergySaving();
    }
    @Override
    public void turnOff() {
        decoratedDevice.turnOff();
        enableEnergySaving();
    }
    @Override
    public void set(int x){
        decoratedDevice.set(x);
        enableEnergySaving();
    }
    @Override
    public void ecoMode() {
        decoratedDevice.ecoMode();
        enableEnergySaving();
    }

    private void enableEnergySaving() {
        System.out.println("Energy saving mode activated.");
    }
}

