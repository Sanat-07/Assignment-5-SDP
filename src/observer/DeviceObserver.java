package observer;

public interface DeviceObserver {
    void update(String deviceName, String event, Object data);
}

