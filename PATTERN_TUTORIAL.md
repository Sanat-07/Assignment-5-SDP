# 🎓 Design Patterns Tutorial - Қолдану Нұсқаулығы

## 📚 Мазмұны

1. [Factory Pattern қолдану](#1-factory-pattern)
2. [Decorator Pattern қолдану](#2-decorator-pattern)
3. [Facade Pattern қолдану](#3-facade-pattern)
4. [Builder Pattern қолдану](#4-builder-pattern)
5. [Толық мысал](#5-толық-мысал)

---

## 1. Factory Pattern қолдану 🏭

### Не үшін керек?
Құрылғыларды жасау оңай болу үшін. `new AirConditioner()` деп емес, Factory арқылы жасаймыз.

### ❌ Бұрын (Factory-сіз):
```java
Light light = new Light();
AirConditioner ac = new AirConditioner();
SmartLock lock = new SmartLock();
```

### ✅ Енді (Factory-мен):
```java
// 1-әдіс: Enum арқылы
Device light = DeviceFactory.createDevice(DeviceType.LIGHT);
Device ac = DeviceFactory.createDevice(DeviceType.AIR_CONDITIONER);
Device lock = DeviceFactory.createDevice(DeviceType.SMART_LOCK);

// 2-әдіс: String арқылы
Device blinds = DeviceFactory.createDevice("smart_blinds");
Device vacuum = DeviceFactory.createDevice("robot_vacuum");
```

### 💡 Артықшылығы:
- Барлық құрылғыларды бір жерден жасау
- Жаңа құрылғы қосу оңай
- Код таза

---

## 2. Decorator Pattern қолдану 🎨

### Не үшін керек?
Құрылғыға қосымша функция қосу үшін. Бастапқы класты өзгертпейміз!

### Қолжетімді декораторлар:
1. **VoiceControlDecorator** - дауыс басқару
2. **RemoteAccessDecorator** - қашықтан басқару
3. **EnergySavingDecorator** - энергия үнемдеу

### 📝 Мысал 1: Бір декоратор

```java
// Қарапайым кондиционер
Device ac = DeviceFactory.createDevice(DeviceType.AIR_CONDITIONER);
ac.turnOn();  // "Air Conditioner is ON"

// Дауыс басқарумен кондиционер
Device voiceAC = new VoiceControlDecorator(ac);
voiceAC.turnOn();  
// "Air Conditioner is ON"
// "Voice control enabled for this device."
```

### 📝 Мысал 2: Екі декоратор стэк

```java
Device smartLock = DeviceFactory.createDevice(DeviceType.SMART_LOCK);

// Voice + Energy
Device voiceEnergyLock = new VoiceControlDecorator(
    new EnergySavingDecorator(smartLock)
);

voiceEnergyLock.turnOn();
// "Smart Lock UNLOCKED"
// "Energy saving mode activated"
// "Voice control enabled"
```

### 📝 Мысал 3: Үш декоратор стэк

```java
Device blinds = DeviceFactory.createDevice(DeviceType.SMART_BLINDS);

// Voice + Remote + Energy
Device superSmartBlinds = new VoiceControlDecorator(
    new RemoteAccessDecorator(
        new EnergySavingDecorator(blinds)
    )
);

superSmartBlinds.turnOn();
// "Smart Blinds are FULLY OPEN"
// "Energy saving mode activated"
// "Remote access via app enabled"
// "Voice control enabled"
```

### 🎯 Қай декораторды қашан қолдану керек?

| Декоратор | Қашан қолдану | Мысал |
|-----------|---------------|-------|
| **VoiceControlDecorator** | Дауыспен басқарғың келсе | "Alexa, turn on AC" |
| **RemoteAccessDecorator** | Телефоннан басқарғың келсе | Жұмыстан үйдегі құрылғыны басқару |
| **EnergySavingDecorator** | Энергия үнемдегің келсе | Электр ақшасын азайту |

---

## 3. Facade Pattern қолдану 🎭

### Не үшін керек?
Көп құрылғыны бір команда арқылы басқару үшін.

### HomeAutomationFacade методтары:

#### 1. **startPartyMode()** - Той режимі
```java
HomeAutomationFacade home = new HomeAutomationFacade(
    light, musicSystem, thermostat, camera, door
);

home.startPartyMode();
// Автоматты:
// - Жарық қосылады + dim mode
// - Музыка қосылады (80%)
```

#### 2. **activateNightMode()** - Түн режимі
```java
home.activateNightMode();
// Автоматты:
// - Жарық өшеді
// - Термостат eco mode
// - Камера қосылады
// - Есік жабылады
```

#### 3. **leaveHome()** - Үйден шығу
```java
home.leaveHome();
// Автоматты:
// - Барлық құрылғы өшеді
// - Камера қосылады
// - Есік жабылады
// - "All systems secured"
```

### 💡 Жаңа режим қосу:

Facade класына жаңа метод қосыңыз:

```java
public void morningMode() {
    System.out.println("\n--- Morning Mode ---");
    smartBlinds.turnOn();        // Перделер ашылады
    smartLight.turnOn();          // Жарық қосылады
    smartAC.set(22);              // Кондиционер 22°C
    smartVacuum.turnOn();         // Робот тазалайды
}
```

---

## 4. Builder Pattern қолдану 🏗️

### Не үшін керек?
SmartHome конфигурациясын құру үшін. Бір-бірден қосып, соңында `build()` басамыз.

### 📝 Мысал 1: Минималды үй

```java
SmartHome myHome = new SmartHomeBuilder()
    .setHomeName("My First Smart Home")
    .setOwner("Sanat")
    .build();
```

### 📝 Мысал 2: Толық үй

```java
SmartHome luxuryHome = new SmartHomeBuilder()
    .setHomeName("Luxury Smart Home")
    .setOwner("Nurkeldi")
    .addDevice(DeviceType.SMART_TV)
    .addDevice(DeviceType.MUSIC_SYSTEM)
    .addDevice(DeviceType.AIR_CONDITIONER)
    .addDevice(DeviceType.SMART_LOCK)
    .addDevice(DeviceType.SMART_BLINDS)
    .addDevice(DeviceType.ROBOT_VACUUM)
    .enableVoiceControl()
    .enableRemoteAccess()
    .enableEnergySaving()
    .build();

// Конфигурацияны көру
luxuryHome.displayConfiguration();
```

### 📝 Мысал 3: Таңдап қосу

```java
SmartHome customHome = new SmartHomeBuilder()
    .setHomeName("Custom Home")
    .setOwner("Mansur")
    .addDevice(DeviceType.AIR_CONDITIONER)  // Тек кондиционер
    .addDevice(DeviceType.ROBOT_VACUUM)     // Тек робот
    .enableEnergySaving()                   // Тек energy saving
    .build();
```

---

## 5. Толық мысал: Барлық паттерндерді қолдану

### Сценарий: Жаңа пәтер Setup

```java
public static void main(String[] args) {
    // 1️⃣ FACTORY: Құрылғыларды жасау
    AirConditioner ac = (AirConditioner) DeviceFactory.createDevice(DeviceType.AIR_CONDITIONER);
    SmartLock lock = (SmartLock) DeviceFactory.createDevice(DeviceType.SMART_LOCK);
    SmartBlinds blinds = (SmartBlinds) DeviceFactory.createDevice(DeviceType.SMART_BLINDS);
    RobotVacuum vacuum = (RobotVacuum) DeviceFactory.createDevice(DeviceType.ROBOT_VACUUM);
    Light light = (Light) DeviceFactory.createDevice(DeviceType.LIGHT);
    MusicSystem music = (MusicSystem) DeviceFactory.createDevice(DeviceType.MUSIC_SYSTEM);
    
    // 2️⃣ DECORATOR: Функция қосу
    Device smartAC = new VoiceControlDecorator(
        new RemoteAccessDecorator(
            new EnergySavingDecorator(ac)
        )
    );
    
    Device smartLock = new VoiceControlDecorator(
        new RemoteAccessDecorator(lock)
    );
    
    Device smartBlinds = new RemoteAccessDecorator(
        new EnergySavingDecorator(blinds)
    );
    
    // 3️⃣ BUILDER: SmartHome құру
    SmartHome myHome = new SmartHomeBuilder()
        .setHomeName("Modern Apartment")
        .setOwner("Your Name")
        .addDevice(DeviceType.AIR_CONDITIONER)
        .addDevice(DeviceType.SMART_LOCK)
        .addDevice(DeviceType.SMART_BLINDS)
        .addDevice(DeviceType.ROBOT_VACUUM)
        .enableAllFeatures()
        .build();
    
    myHome.displayConfiguration();
    
    // 4️⃣ Құрылғыларды қолдану
    System.out.println("\n=== Morning Routine ===");
    smartBlinds.turnOn();        // Перделер ашылады + Remote + Energy
    smartAC.set(22);             // Кондиционер 22°C + Voice + Remote + Energy
    smartLock.turnOn();          // Есік ашылады + Voice + Remote
    
    System.out.println("\n=== Start Cleaning ===");
    vacuum.turnOn();             // Робот тазалайды
    
    System.out.println("\n=== Evening ===");
    smartBlinds.turnOff();       // Перделер жабылады
    smartAC.ecoMode();           // Eco mode
    smartLock.turnOff();         // Есік жабылады
}
```

---

## 🎯 Қорытынды: Әр паттерн не істейді?

| Pattern | Міндеті | Мысал |
|---------|---------|-------|
| **Factory** 🏭 | Құрылғы жасау | `DeviceFactory.createDevice(DeviceType.AIR_CONDITIONER)` |
| **Decorator** 🎨 | Функция қосу | `new VoiceControlDecorator(device)` |
| **Facade** 🎭 | Көп құрылғы басқару | `home.startPartyMode()` |
| **Builder** 🏗️ | SmartHome құру | `new SmartHomeBuilder().build()` |

---

## 📖 Тапсырма: Өзіңіз жасап көріңіз!

1. ✅ Жаңа құрылғы жасаңыз (Factory)
2. ✅ Оған 3 декоратор қосыңыз (Decorator)
3. ✅ SmartHome-ға қосыңыз (Builder)
4. ✅ Facade-қа жаңа режим қосыңыз

**Сәттілік!** 🚀

