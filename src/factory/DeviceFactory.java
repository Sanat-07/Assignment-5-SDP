package factory;

import devices.*;

public class DeviceFactory {
    
    public static Device createDevice(DeviceType type) {
        switch (type) {
            case LIGHT:
                return new Light();
            case THERMOSTAT:
                return new Thermostat();
            case DOOR:
                return new Door();
            case SECURITY_CAMERA:
                return new SecurityCamera();
            case SMART_TV:
                return new SmartTv();
            case MUSIC_SYSTEM:
                return new MusicSystem();
            case AIR_CONDITIONER:
                return new AirConditioner();
            case SMART_LOCK:
                return new SmartLock();
            case SMART_BLINDS:
                return new SmartBlinds();
            case ROBOT_VACUUM:
                return new RobotVacuum();
            default:
                throw new IllegalArgumentException("Unknown device type: " + type);
        }
    }
    
    public static Device createDevice(String deviceName) {
        try {
            DeviceType type = DeviceType.valueOf(deviceName.toUpperCase().replace(" ", "_"));
            return createDevice(type);
        } catch (IllegalArgumentException e) {
            System.out.println("Unknown device: " + deviceName);
            return null;
        }
    }
    
    public static void displayAvailableDevices() {
        System.out.println("\nAvailable Device Types:");
        for (DeviceType type : DeviceType.values()) {
            System.out.println("- " + type.name());
        }
    }
}

