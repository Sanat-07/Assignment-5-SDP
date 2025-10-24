# Assignment 5 - Software Design Patterns (SDP)

## Project Description
This is a Java-based home automation system implementing various design patterns including:
- **Facade Pattern** - HomeAutomationFacade
- **Decorator Pattern** - Device decorators (VoiceControl, RemoteAccess, EnergySaving)
- **Singleton Pattern** - UserDatabase

## Project Structure
```
src/
├── Device.java                    # Base device interface
├── DeviceDecorator.java          # Abstract decorator
├── Light.java                    # Light device implementation
├── Thermostat.java               # Thermostat device implementation
├── Door.java                     # Door device implementation
├── SecurityCamera.java           # Security camera implementation
├── SmartTv.java                  # Smart TV implementation
├── MusicSystem.java              # Music system implementation
├── VoiceControlDecorator.java    # Voice control decorator
├── RemoteAccessDecorator.java    # Remote access decorator
├── EnergySavingDecorator.java    # Energy saving decorator
├── HomeAutomationFacade.java     # Facade for home automation
├── User.java                     # User model
├── UserDatabase.java             # Singleton user database
└── Main.java                     # Main application entry point
```

## How to Run
1. Compile the Java files:
   ```bash
   javac src/*.java
   ```

2. Run the main class:
   ```bash
   java -cp . Main
   ```

## Design Patterns Used
1. **Facade Pattern**: Simplifies complex subsystem interactions
2. **Decorator Pattern**: Adds functionality to devices dynamically
3. **Singleton Pattern**: Ensures single instance of UserDatabase

## Author
Sanat-07

