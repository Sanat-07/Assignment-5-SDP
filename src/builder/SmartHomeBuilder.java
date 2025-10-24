package builder;

import devices.*;
import factory.DeviceFactory;
import factory.DeviceType;

public class SmartHomeBuilder {
    Device light;
    Device thermostat;
    Device door;
    Device securityCamera;
    Device smartTv;
    Device musicSystem;
    
    boolean hasVoiceControl = false;
    boolean hasRemoteAccess = false;
    boolean hasEnergySaving = false;
    
    String homeName;
    String owner;

    public SmartHomeBuilder() {
        this.light = DeviceFactory.createDevice(DeviceType.LIGHT);
        this.thermostat = DeviceFactory.createDevice(DeviceType.THERMOSTAT);
        this.door = DeviceFactory.createDevice(DeviceType.DOOR);
        this.securityCamera = DeviceFactory.createDevice(DeviceType.SECURITY_CAMERA);
    }
    public SmartHomeBuilder withLight(Device light) {
        this.light = light;
        return this;
    }
    
    public SmartHomeBuilder withThermostat(Device thermostat) {
        this.thermostat = thermostat;
        return this;
    }
    
    public SmartHomeBuilder withDoor(Device door) {
        this.door = door;
        return this;
    }
    
    public SmartHomeBuilder withSecurityCamera(Device camera) {
        this.securityCamera = camera;
        return this;
    }
    
    public SmartHomeBuilder withSmartTv(Device tv) {
        this.smartTv = tv;
        return this;
    }
    
    public SmartHomeBuilder withMusicSystem(Device music) {
        this.musicSystem = music;
        return this;
    }
    
    public SmartHomeBuilder addDevice(DeviceType type) {
        Device device = DeviceFactory.createDevice(type);
        switch (type) {
            case SMART_TV:
                this.smartTv = device;
                break;
            case MUSIC_SYSTEM:
                this.musicSystem = device;
                break;
            default:
                System.out.println("Device already included by default: " + type);
        }
        return this;
    }
    
    public SmartHomeBuilder enableVoiceControl() {
        this.hasVoiceControl = true;
        return this;
    }
    
    public SmartHomeBuilder enableRemoteAccess() {
        this.hasRemoteAccess = true;
        return this;
    }
    
    public SmartHomeBuilder enableEnergySaving() {
        this.hasEnergySaving = true;
        return this;
    }
    
    public SmartHomeBuilder enableAllFeatures() {
        this.hasVoiceControl = true;
        this.hasRemoteAccess = true;
        this.hasEnergySaving = true;
        return this;
    }
    
    public SmartHomeBuilder setHomeName(String name) {
        this.homeName = name;
        return this;
    }
    
    public SmartHomeBuilder setOwner(String owner) {
        this.owner = owner;
        return this;
    }
    
    public SmartHome build() {
        return new SmartHome(this);
    }
}

