# 🎓 Design Patterns Tutorial - Қолдану Нұсқаулығы

## 📚 Мазмұны

1. [Decorator Pattern қолдану](#1-decorator-pattern)
2. [Facade Pattern қолдану](#2-facade-pattern)
3. [Толық мысал](#3-толық-мысал)

---

## 1. Decorator Pattern қолдану 🎨

### Не үшін керек?
Құрылғыға қосымша функция қосу үшін. Бастапқы класты өзгертпейміз!

### Қолжетімді декораторлар:
1. **VoiceControlDecorator** - дауыс басқару
2. **RemoteAccessDecorator** - қашықтан басқару
3. **EnergySavingDecorator** - энергия үнемдеу

### 📝 Мысал 1: Бір декоратор

```java
// Қарапайым кондиционер
AirConditioner ac = new AirConditioner();
ac.turnOn();  // "Air Conditioner is ON"

// Дауыс басқарумен кондиционер
Device voiceAC = new VoiceControlDecorator(ac);
voiceAC.turnOn();  
// "Air Conditioner is ON"
// "Voice control enabled for this device."
```

### 📝 Мысал 2: Екі декоратор стэк

```java
SmartLock smartLock = new SmartLock();

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
SmartBlinds blinds = new SmartBlinds();

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

## 2. Facade Pattern қолдану 🎭

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

## 3. Толық мысал: Барлық паттерндерді қолдану

### Сценарий: Жаңа пәтер Setup

```java
public static void main(String[] args) {
    // 1️⃣ Құрылғыларды жасау
    AirConditioner ac = new AirConditioner();
    SmartLock lock = new SmartLock();
    SmartBlinds blinds = new SmartBlinds();
    RobotVacuum vacuum = new RobotVacuum();
    Light light = new Light();
    MusicSystem music = new MusicSystem();
    
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
    
    // 3️⃣ FACADE: Көп құрылғыны басқару
    HomeAutomationFacade home = new HomeAutomationFacade(
        light, music, thermostat, camera, door
    );
    
    // 4️⃣ Құрылғыларды қолдану
    System.out.println("\n=== Morning Routine ===");
    smartBlinds.turnOn();        // Перделер ашылады + Remote + Energy
    smartAC.set(22);             // Кондиционер 22°C + Voice + Remote + Energy
    smartLock.turnOn();          // Есік ашылады + Voice + Remote
    
    System.out.println("\n=== Start Cleaning ===");
    vacuum.turnOn();             // Робот тазалайды
    
    System.out.println("\n=== Party Time ===");
    home.startPartyMode();       // Facade - барлығын бірге басқару
    
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
| **Decorator** 🎨 | Функция қосу | `new VoiceControlDecorator(device)` |
| **Facade** 🎭 | Көп құрылғы басқару | `home.startPartyMode()` |
| **Singleton** 🔒 | Бір instance | `UserDatabase` (тек біреу болады) |

---

## 📖 Тапсырма: Өзіңіз жасап көріңіз!

1. ✅ Жаңа құрылғы жасаңыз (new Device())
2. ✅ Оған 3 декоратор қосыңыз (Decorator)
3. ✅ Facade-қа жаңа режим қосыңыз

**Сәттілік!** 🚀

