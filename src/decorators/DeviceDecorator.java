package decorators;

import devices.Device;

public abstract class DeviceDecorator implements Device {
    protected Device decoratedDevice;

    public DeviceDecorator(Device decoratedDevice) {
        this.decoratedDevice = decoratedDevice;
    }

    @Override
    public void turnOn() {
        decoratedDevice.turnOn();
    }
    @Override
    public void turnOff() {
        decoratedDevice.turnOff();
    }

    @Override
    public void set(int t) {
        decoratedDevice.set(t);
    }
    @Override
    public void ecoMode() {
        decoratedDevice.ecoMode();
    }

}

