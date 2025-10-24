# Assignment 5 - Software Design Patterns (SDP)

## Project Description
This is a Java-based home automation system implementing **3 design patterns**:
- **Decorator Pattern** - Device decorators (VoiceControl, RemoteAccess, EnergySaving)
- **Facade Pattern** - HomeAutomationFacade for simplified operations
- **Singleton Pattern** - UserDatabase for centralized user management

## Project Structure
```
src/
├── devices/                      # Device implementations (11 devices)
│   ├── Device.java              # Base device interface
│   ├── Light.java               # Light device implementation
│   ├── Thermostat.java          # Thermostat device implementation
│   ├── Door.java                # Door device implementation
│   ├── SecurityCamera.java      # Security camera implementation
│   ├── SmartTv.java             # Smart TV implementation
│   ├── MusicSystem.java         # Music system implementation
│   ├── AirConditioner.java      # Air conditioner
│   ├── SmartLock.java           # Smart lock
│   ├── SmartBlinds.java         # Smart blinds
│   └── RobotVacuum.java         # Robot vacuum cleaner
├── decorators/                   # Decorator pattern implementations
│   ├── DeviceDecorator.java     # Abstract decorator base class
│   ├── VoiceControlDecorator.java    # Voice control decorator
│   ├── RemoteAccessDecorator.java    # Remote access decorator
│   └── EnergySavingDecorator.java    # Energy saving decorator
├── facade/                       # Facade pattern implementation
│   └── HomeAutomationFacade.java     # Facade for home automation
├── user/                         # User management
│   ├── User.java                # User model
│   └── UserDatabase.java        # Singleton user database
└── Main.java                     # Main application entry point
```

## Package Organization

### `devices` Package
Contains all device implementations and the base `Device` interface. Each device implements core functionality like `turnOn()`, `turnOff()`, `set()`, and `ecoMode()`.

### `decorators` Package  
Contains the decorator pattern implementation. Decorators add additional functionality to devices:
- **VoiceControlDecorator**: Adds voice control capabilities
- **RemoteAccessDecorator**: Adds remote access via mobile app
- **EnergySavingDecorator**: Adds energy-saving features

### `facade` Package
Contains the `HomeAutomationFacade` class that simplifies complex device interactions and provides convenient methods like:
- `startPartyMode()`: Activates party mode settings
- `activateNightMode()`: Activates night mode settings
- `leaveHome()`: Secures all devices when leaving

### `user` Package
Contains user authentication and management:
- **User**: User model with credentials
- **UserDatabase**: Singleton pattern for user storage and authentication

## How to Run

### Compile
```bash
cd /Users/admin/IdeaProjects/sdpp5
javac -d out/production/sdpp5 src/**/*.java src/*.java
```

### Run
```bash
cd /Users/admin/IdeaProjects/sdpp5
java -cp out/production/sdpp5 Main
```

Or using IDE:
1. Open the project in IntelliJ IDEA
2. Run `Main.java`

## Design Patterns Used

### 1. Decorator Pattern 🎨
**Purpose**: Adds functionality to devices dynamically without modifying their structure  
**Implementation**: Multiple decorators can be stacked to add voice control, remote access, and energy-saving features to any device.

**Example Usage**:
```java
Light light = new Light();

// Single decorator
Device voiceLight = new VoiceControlDecorator(light);

// Multiple decorators stacked
Device smartLight = new RemoteAccessDecorator(
    new VoiceControlDecorator(
        new EnergySavingDecorator(light)
    )
);
```

### 2. Facade Pattern 🎭
**Purpose**: Simplifies complex subsystem interactions  
**Implementation**: `HomeAutomationFacade` provides simple methods like `startPartyMode()` that coordinate multiple devices.

### 3. Singleton Pattern 🔒
**Purpose**: Ensures single instance of UserDatabase  
**Implementation**: `UserDatabase` manages all users in a centralized location.

## Features
- ✅ User authentication system
- ✅ **11 Smart Devices** (Light, Thermostat, Door, Camera, TV, Music, AC, Lock, Blinds, Vacuum)
- ✅ **Decorator Pattern** - Dynamic feature extension (VoiceControl, RemoteAccess, EnergySaving)
- ✅ **Facade Pattern** - Simplified high-level control (Party Mode, Night Mode, Leave Home)
- ✅ **Singleton Pattern** - UserDatabase
- ✅ Voice control interface
- ✅ Remote control via app
- ✅ Energy-saving modes

## Default Users
- **Login**: `sanat` | **Password**: `2007` | **Name**: Sanat
- **Login**: `nurik` | **Password**: `2009` | **Name**: Nurkeldi  
- **Login**: `mans` | **Password**: `2006` | **Name**: Mansur

## Author
Sanat-07

## GitHub Repository
https://github.com/Sanat-07/Assignment-5-SDP
