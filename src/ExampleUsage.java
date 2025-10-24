import devices.*;
import decorators.*;
import factory.DeviceFactory;
import factory.DeviceType;

public class ExampleUsage {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║  Design Patterns - Қолдану Мысалдары  ║");
        System.out.println("╚════════════════════════════════════════╝\n");
        
        example1_Factory();
        example2_DecoratorSingle();
        example3_DecoratorDouble();
        example4_DecoratorTriple();
        example5_RealWorldScenario();
    }
    
    static void example1_Factory() {
        System.out.println("📌 МЫСАЛ 1: Factory Pattern");
        System.out.println("───────────────────────────────────────\n");
        
        Device ac = DeviceFactory.createDevice(DeviceType.AIR_CONDITIONER);
        Device lock = DeviceFactory.createDevice(DeviceType.SMART_LOCK);
        Device blinds = DeviceFactory.createDevice(DeviceType.SMART_BLINDS);
        Device vacuum = DeviceFactory.createDevice(DeviceType.ROBOT_VACUUM);
        
        System.out.println("✓ 4 құрылғы Factory арқылы жасалды!\n");
        ac.turnOn();
        lock.turnOn();
        blinds.set(50);
        vacuum.turnOn();
        
        System.out.println("\n");
    }
    
    static void example2_DecoratorSingle() {
        System.out.println("📌 МЫСАЛ 2: Decorator - Бір декоратор");
        System.out.println("───────────────────────────────────────\n");
        
        Device ac = DeviceFactory.createDevice(DeviceType.AIR_CONDITIONER);
        
        System.out.println("Қарапайым кондиционер:");
        ac.turnOn();
        
        System.out.println("\nДауыс басқарумен кондиционер:");
        Device voiceAC = new VoiceControlDecorator(ac);
        voiceAC.turnOn();
        
        System.out.println("\n");
    }
    
    static void example3_DecoratorDouble() {
        System.out.println("📌 МЫСАЛ 3: Decorator - Екі декоратор");
        System.out.println("───────────────────────────────────────\n");
        
        Device lock = DeviceFactory.createDevice(DeviceType.SMART_LOCK);
        
        Device smartLock = new VoiceControlDecorator(
            new RemoteAccessDecorator(lock)
        );
        
        System.out.println("Smart Lock (Voice + Remote):");
        smartLock.turnOn();
        
        System.out.println("\n");
    }
    
    static void example4_DecoratorTriple() {
        System.out.println("📌 МЫСАЛ 4: Decorator - Үш декоратор");
        System.out.println("───────────────────────────────────────\n");
        
        Device blinds = DeviceFactory.createDevice(DeviceType.SMART_BLINDS);
        
        Device superSmartBlinds = new VoiceControlDecorator(
            new RemoteAccessDecorator(
                new EnergySavingDecorator(blinds)
            )
        );
        
        System.out.println("Super Smart Blinds (Voice + Remote + Energy):");
        superSmartBlinds.turnOn();
        
        System.out.println("\n");
    }
    
    static void example5_RealWorldScenario() {
        System.out.println("📌 МЫСАЛ 5: Нақты сценарий - Таңғы режим");
        System.out.println("───────────────────────────────────────\n");
        
        AirConditioner ac = (AirConditioner) DeviceFactory.createDevice(DeviceType.AIR_CONDITIONER);
        SmartBlinds blinds = (SmartBlinds) DeviceFactory.createDevice(DeviceType.SMART_BLINDS);
        RobotVacuum vacuum = (RobotVacuum) DeviceFactory.createDevice(DeviceType.ROBOT_VACUUM);
        SmartLock lock = (SmartLock) DeviceFactory.createDevice(DeviceType.SMART_LOCK);
        
        Device smartAC = new RemoteAccessDecorator(new EnergySavingDecorator(ac));
        Device smartBlinds = new RemoteAccessDecorator(new EnergySavingDecorator(blinds));
        Device smartVacuum = new VoiceControlDecorator(vacuum);
        Device smartLock = new VoiceControlDecorator(new RemoteAccessDecorator(lock));
        
        System.out.println("🌅 Таңертең 7:00 - Автоматты түрде:");
        System.out.println("────────────────────────────────────");
        
        System.out.println("\n1️⃣ Перделер ашылады:");
        smartBlinds.turnOn();
        
        System.out.println("\n2️⃣ Кондиционер қосылады:");
        smartAC.set(22);
        
        System.out.println("\n3️⃣ Есік ашылады:");
        smartLock.turnOn();
        
        System.out.println("\n4️⃣ Робот тазалауды бастайды:");
        smartVacuum.turnOn();
        
        System.out.println("\n✓ Таңғы режим аяқталды!");
        System.out.println("\n");
    }
}

