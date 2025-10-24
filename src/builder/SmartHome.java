package builder;

import devices.*;
import decorators.*;

public class SmartHome {
    private Device light;
    private Device thermostat;
    private Device door;
    private Device securityCamera;
    private Device smartTv;
    private Device musicSystem;
    
    private boolean hasVoiceControl;
    private boolean hasRemoteAccess;
    private boolean hasEnergySaving;
    
    private String homeName;
    private String owner;

    SmartHome(SmartHomeBuilder builder) {
        this.light = builder.light;
        this.thermostat = builder.thermostat;
        this.door = builder.door;
        this.securityCamera = builder.securityCamera;
        this.smartTv = builder.smartTv;
        this.musicSystem = builder.musicSystem;
        this.hasVoiceControl = builder.hasVoiceControl;
        this.hasRemoteAccess = builder.hasRemoteAccess;
        this.hasEnergySaving = builder.hasEnergySaving;
        this.homeName = builder.homeName;
        this.owner = builder.owner;
        
        applyDecorators();
    }
    
    private void applyDecorators() {
        if (hasEnergySaving || hasVoiceControl || hasRemoteAccess) {
            light = applyDecoratorToDevice(light);
            thermostat = applyDecoratorToDevice(thermostat);
            door = applyDecoratorToDevice(door);
            securityCamera = applyDecoratorToDevice(securityCamera);
            if (smartTv != null) smartTv = applyDecoratorToDevice(smartTv);
            if (musicSystem != null) musicSystem = applyDecoratorToDevice(musicSystem);
        }
    }
    
    private Device applyDecoratorToDevice(Device device) {
        if (device == null) return null;
        
        Device decorated = device;
        if (hasEnergySaving) {
            decorated = new EnergySavingDecorator(decorated);
        }
        if (hasVoiceControl) {
            decorated = new VoiceControlDecorator(decorated);
        }
        if (hasRemoteAccess) {
            decorated = new RemoteAccessDecorator(decorated);
        }
        return decorated;
    }
    
    public void displayConfiguration() {
        System.out.println("\n========================================");
        System.out.println("Smart Home Configuration");
        System.out.println("========================================");
        System.out.println("Home Name: " + (homeName != null ? homeName : "N/A"));
        System.out.println("Owner: " + (owner != null ? owner : "N/A"));
        System.out.println("\nDevices Installed:");
        System.out.println("  Light: " + (light != null ? "Yes" : "No"));
        System.out.println("  Thermostat: " + (thermostat != null ? "Yes" : "No"));
        System.out.println("  Door: " + (door != null ? "Yes" : "No"));
        System.out.println("  Security Camera: " + (securityCamera != null ? "Yes" : "No"));
        System.out.println("  Smart TV: " + (smartTv != null ? "Yes" : "No"));
        System.out.println("  Music System: " + (musicSystem != null ? "Yes" : "No"));
        System.out.println("\nFeatures Enabled:");
        System.out.println("  Voice Control: " + (hasVoiceControl ? "Enabled" : "Disabled"));
        System.out.println("  Remote Access: " + (hasRemoteAccess ? "Enabled" : "Disabled"));
        System.out.println("  Energy Saving: " + (hasEnergySaving ? "Enabled" : "Disabled"));
        System.out.println("========================================\n");
    }
    public Device getLight() { return light; }
    public Device getThermostat() { return thermostat; }
    public Device getDoor() { return door; }
    public Device getSecurityCamera() { return securityCamera; }
    public Device getSmartTv() { return smartTv; }
    public Device getMusicSystem() { return musicSystem; }
    public String getHomeName() { return homeName; }
    public String getOwner() { return owner; }
}

