# Assignment 5 - Software Design Patterns (SDP)

## Project Description
This is a Java-based home automation system implementing **5 design patterns**:
- **Decorator Pattern** - Device decorators (VoiceControl, RemoteAccess, EnergySaving)
- **Facade Pattern** - HomeAutomationFacade for simplified operations
- **Factory Pattern** - DeviceFactory for creating device instances
- **Builder Pattern** - SmartHomeBuilder for flexible home configuration
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
│   ├── AirConditioner.java      # Air conditioner (NEW!)
│   ├── SmartLock.java           # Smart lock (NEW!)
│   ├── SmartBlinds.java         # Smart blinds (NEW!)
│   └── RobotVacuum.java         # Robot vacuum cleaner (NEW!)
├── factory/                      # Factory pattern (NEW!)
│   ├── DeviceType.java          # Enum for device types
│   └── DeviceFactory.java       # Factory for creating devices
├── builder/                      # Builder pattern
│   ├── SmartHome.java           # Smart home configuration object
│   └── SmartHomeBuilder.java    # Builder for smart home setup
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

### 3. Facade Pattern 🎭
**Purpose**: Simplifies complex subsystem interactions  
**Implementation**: `HomeAutomationFacade` provides simple methods like `startPartyMode()` that coordinate multiple devices.

### 4. Decorator Pattern 🎨
**Purpose**: Adds functionality to devices dynamically without modifying their structure  
**Implementation**: Multiple decorators can be stacked to add voice control, remote access, and energy-saving features to any device.

### 5. Singleton Pattern 🔒
**Purpose**: Ensures single instance of UserDatabase  
**Implementation**: `UserDatabase` manages all users in a centralized location.

## Features
- ✅ User authentication system
- ✅ **11 Smart Devices** (Light, Thermostat, Door, Camera, TV, Music, AC, Lock, Blinds, Vacuum)
- ✅ **Decorator Pattern** - Dynamic feature extension
- ✅ **Facade Pattern** - Simplified high-level control
- ✅ **Factory Pattern** - Dynamic device creation (11 types)
- ✅ **Builder Pattern** - Flexible smart home configuration
- ✅ Voice control interface
- ✅ Remote control via app
- ✅ Energy-saving modes
- ✅ Pre-configured scenarios (Party Mode, Night Mode, Leave Home)
- ✅ **Pattern Tutorial** - Step-by-step guide in Kazakh
- ✅ **Example Usage** - Code examples for all patterns

## Default Users
- **Login**: `sanat` | **Password**: `2007` | **Name**: Sanat
- **Login**: `nurik` | **Password**: `2009` | **Name**: Nurkeldi  
- **Login**: `mans` | **Password**: `2006` | **Name**: Mansur

## 📚 Learning Resources

### PATTERN_TUTORIAL.md
Толық нұсқаулық қазақ тілінде:
- Factory Pattern қалай қолдану
- Decorator Pattern қалай қолдану (1, 2, 3 декоратор)
- Facade Pattern қалай қолдану
- Builder Pattern қалай қолдану
- Толық мысалдар

### ExampleUsage.java
5 практикалық мысал:
1. Factory Pattern - құрылғы жасау
2. Decorator - бір декоратор
3. Decorator - екі декоратор
4. Decorator - үш декоратор
5. Нақты сценарий - таңғы режим

**Іске қосу:**
```bash
javac -d out src/**/*.java src/*.java
java -cp out ExampleUsage
```

## Author
Sanat-07

## GitHub Repository
https://github.com/Sanat-07/Assignment-5-SDP
