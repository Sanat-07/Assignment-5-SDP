# Assignment 5 - Software Design Patterns (SDP)

## Project Description
This is a Java-based home automation system implementing **6 design patterns**:
- **Factory Pattern** - DeviceFactory for creating device instances
- **Builder Pattern** - SmartHomeBuilder for flexible home configuration
- **Observer Pattern** - Device monitoring and automatic responses
- **Facade Pattern** - HomeAutomationFacade for simplified operations
- **Decorator Pattern** - Device decorators (VoiceControl, RemoteAccess, EnergySaving)
- **Singleton Pattern** - UserDatabase for centralized user management

## Project Structure
```
src/
├── devices/                      # Device implementations
│   ├── Device.java              # Base device interface
│   ├── Light.java               # Light device implementation
│   ├── Thermostat.java          # Thermostat device implementation
│   ├── Door.java                # Door device implementation
│   ├── SecurityCamera.java      # Security camera implementation
│   ├── SmartTv.java             # Smart TV implementation
│   └── MusicSystem.java         # Music system implementation
├── factory/                      # Factory pattern (NEW!)
│   ├── DeviceType.java          # Enum for device types
│   └── DeviceFactory.java       # Factory for creating devices
├── builder/                      # Builder pattern
│   ├── SmartHome.java           # Smart home configuration object
│   └── SmartHomeBuilder.java    # Builder for smart home setup
├── observer/                     # Observer pattern (NEW!)
│   ├── DeviceObserver.java      # Observer interface
│   ├── DeviceSubject.java       # Subject for managing observers
│   ├── CameraObserver.java      # Monitors door events
│   ├── TemperatureObserver.java # Monitors temperature changes
│   └── LightObserver.java       # Monitors music system events
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

### `factory` Package (NEW! 🎉)
Implements the **Factory Pattern** for device creation:
- **DeviceType**: Enum defining all available device types
- **DeviceFactory**: Factory class with static methods to create device instances
- Provides centralized device creation logic
- Supports both enum-based and string-based device creation

### `builder` Package
Implements the **Builder Pattern** for smart home configuration:
- **SmartHome**: Immutable smart home object with all configurations
- **SmartHomeBuilder**: Fluent interface builder for flexible home setup
- Allows step-by-step construction of complex smart home configurations
- Supports method chaining for readable code

### `observer` Package (NEW! 🎉)
Implements the **Observer Pattern** for automatic device responses:
- **DeviceObserver**: Interface for observers
- **DeviceSubject**: Manages and notifies observers
- **CameraObserver**: Camera activates when door opens
- **TemperatureObserver**: Sends alerts when temperature > 30°C
- **LightObserver**: Light dims when music starts

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

### 1. Factory Pattern 🏭
**Purpose**: Encapsulates object creation logic  
**Implementation**: `DeviceFactory` provides static factory methods to create device instances based on `DeviceType` enum or string input.  
**Benefits**: 
- Centralized device creation
- Easy to extend with new device types
- Type-safe device creation

**Example Usage**:
```java
Device light = DeviceFactory.createDevice(DeviceType.LIGHT);
Device tv = DeviceFactory.createDevice("smart_tv");
```

### 2. Builder Pattern 🏗️
**Purpose**: Constructs complex objects step by step  
**Implementation**: `SmartHomeBuilder` uses fluent interface to build `SmartHome` configurations with optional features.  
**Benefits**:
- Flexible and readable object construction
- Supports optional parameters
- Immutable result object

**Example Usage**:
```java
SmartHome home = new SmartHomeBuilder()
    .setHomeName("My Smart Home")
    .setOwner("John")
    .addDevice(DeviceType.SMART_TV)
    .enableAllFeatures()
    .build();
```

### 3. Observer Pattern 👁️
**Purpose**: Enables automatic responses when device states change  
**Implementation**: Devices notify observers when events occur (door opens, temperature changes, music starts).  
**Benefits**:
- Automatic device coordination
- Loose coupling between devices
- Easy to add new behaviors

**Example Usage**:
```java
// Observer monitors door
CameraObserver cameraObserver = new CameraObserver(camera);
door.getSubject().attach(cameraObserver);

// When door opens, camera automatically activates
door.turnOn();  // Camera turns on automatically!
```

**Active Monitoring:**
- 🚪 Door opens → Camera activates
- 🌡️ Temperature > 30°C → Alert notification
- 🎵 Music starts → Light dims to 30%

### 4. Facade Pattern 🎭
**Purpose**: Simplifies complex subsystem interactions  
**Implementation**: `HomeAutomationFacade` provides simple methods like `startPartyMode()` that coordinate multiple devices.

### 5. Decorator Pattern 🎨
**Purpose**: Adds functionality to devices dynamically without modifying their structure  
**Implementation**: Multiple decorators can be stacked to add voice control, remote access, and energy-saving features to any device.

### 6. Singleton Pattern 🔒
**Purpose**: Ensures single instance of UserDatabase  
**Implementation**: `UserDatabase` manages all users in a centralized location.

## Features
- ✅ User authentication system
- ✅ Multiple device support (Light, Thermostat, Door, Camera, TV, Music)
- ✅ **Factory Pattern** - Dynamic device creation
- ✅ **Builder Pattern** - Flexible smart home configuration
- ✅ **Observer Pattern** - Automatic device monitoring and responses
- ✅ Voice control interface
- ✅ Remote control via app
- ✅ Energy-saving modes
- ✅ Pre-configured scenarios (Party Mode, Night Mode, Leave Home)
- ✅ Intelligent automation (door→camera, temp→alert, music→light)

## Default Users
- **Login**: `sanat` | **Password**: `2007` | **Name**: Sanat
- **Login**: `nurik` | **Password**: `2009` | **Name**: Nurkeldi  
- **Login**: `mans` | **Password**: `2006` | **Name**: Mansur

## Author
Sanat-07

## GitHub Repository
https://github.com/Sanat-07/Assignment-5-SDP
