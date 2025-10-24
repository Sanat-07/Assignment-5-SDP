package decorators;

import devices.Device;

public class VoiceControlDecorator extends DeviceDecorator {
    public VoiceControlDecorator(Device decoratedDevice) {
        super(decoratedDevice);
    }

    @Override
    public void turnOn() {
        decoratedDevice.turnOn();
        addVoiceControl();
    }
    @Override
    public void turnOff() {
        decoratedDevice.turnOff();
        addVoiceControl();
    }
    @Override
    public void set(int x){
        decoratedDevice.set(x);
        addVoiceControl();
    }
    @Override
    public void ecoMode() {
        decoratedDevice.ecoMode();
        addVoiceControl();
    }

    private void addVoiceControl() {
        System.out.println("Voice control enabled for this device.");
    }
}

