public class RemoteAccessDecorator extends DeviceDecorator {
    public RemoteAccessDecorator(Device decoratedDevice) {
        super(decoratedDevice);
    }

    @Override
    public void turnOn() {
        decoratedDevice.turnOn();
        addRemoteAccess();
    }
    @Override
    public void turnOff() {
        decoratedDevice.turnOff();
        addRemoteAccess();
    }
    @Override
    public void set(int x){
        decoratedDevice.set(x);
        addRemoteAccess();
    }
    @Override
    public void ecoMode() {
        decoratedDevice.ecoMode();
        addRemoteAccess();
    }

    private void addRemoteAccess() {
        System.out.println("Remote access via app enabled.");
    }
}