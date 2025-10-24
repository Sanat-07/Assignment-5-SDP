
# Smart Home Automation System

A Java-based home automation system demonstrating design patterns implementation.

## Design Patterns

### Decorator Pattern
Dynamically adds functionality to devices without modifying their original code.
- `VoiceControlDecorator` - Adds voice control capability
- `RemoteAccessDecorator` - Adds remote access via mobile app
- `EnergySavingDecorator` - Adds energy-saving features

### Facade Pattern
Simplifies complex device operations with high-level commands.
- `startPartyMode()` - Configures devices for party atmosphere
- `activateNightMode()` - Enables security and turns off lights
- `leaveHome()` - Secures home when leaving

### Singleton Pattern
Ensures single instance of user database for centralized management.

## Project Structure

```
src/
├── devices/              Device implementations (11 devices)
├── decorators/           Decorator pattern implementation
├── facade/               Facade pattern implementation
├── user/                 User authentication (Singleton)
└── Main.java             Application entry point
```

## Devices

- Light
- Thermostat
- Door
- Security Camera
- Smart TV
- Music System
- Air Conditioner
- Smart Lock
- Smart Blinds
- Robot Vacuum

## How to Run

### Using IDE
1. Open project in IntelliJ IDEA
2. Run `Main.java`

### Using Terminal
```bash
javac -d out/production/sdpp5 src/**/*.java src/*.java
java -cp out/production/sdpp5 Main
```

## Usage

### Login
Use any of these credentials:
- `sanat` / `2007`
- `nurik` / `2009`
- `mans` / `2006`

### Control Modes
1. **Remote Control** - Direct device control with decorators
2. **Voice Control** - Voice-activated commands

## Features

- User authentication system
- 11 smart devices
- Dynamic feature addition (decorators)
- Simplified control scenarios (facade)
- Centralized user management (singleton)

## Example

```java
// Create device
Light light = new Light();

// Add decorators
Device smartLight = new RemoteAccessDecorator(
    new VoiceControlDecorator(
        new EnergySavingDecorator(light)
    )
);

// Use decorated device
smartLight.turnOn();
// Output:
// Light is ON.
// Energy saving mode activated.
// Voice control enabled for this device.
// Remote access via app enabled.
```

## Author
Sanat-07

## Repository
https://github.com/Sanat-07/Assignment-5-SDP
