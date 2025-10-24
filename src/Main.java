import devices.*;
import decorators.*;
import facade.HomeAutomationFacade;
import user.User;
import user.UserDatabase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDatabase db = new UserDatabase();

        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        User user = db.login(login, pass);
        if (user == null) {
            System.out.println("Access denied. Wrong credentials.");
            return;
        }

        System.out.println("\nWelcome, " + user.name + "!");
        
        Light light = new Light();
        MusicSystem musicSystem = new MusicSystem();
        Thermostat thermostat = new Thermostat();
        SecurityCamera camera = new SecurityCamera();
        Door door = new Door();
        SmartTv tv = new SmartTv();
        AirConditioner ac = new AirConditioner();
        SmartLock lock = new SmartLock();
        SmartBlinds blinds = new SmartBlinds();
        RobotVacuum vacuum = new RobotVacuum();
        
        door.turnOn();

        Device VoiceSmartLight = new VoiceControlDecorator(new EnergySavingDecorator(light));
        Device VoiceSmartMusic = new VoiceControlDecorator(new EnergySavingDecorator(musicSystem));
        Device VoiceSmartThermostat = new VoiceControlDecorator(new EnergySavingDecorator(thermostat));
        Device VoiceSmartDoor = new VoiceControlDecorator(new EnergySavingDecorator(door));
        Device VoiceSmartAC = new VoiceControlDecorator(new EnergySavingDecorator(ac));
        Device VoiceSmartLock = new VoiceControlDecorator(new EnergySavingDecorator(lock));
        Device VoiceSmartBlinds = new VoiceControlDecorator(new EnergySavingDecorator(blinds));
        Device VoiceSmartVacuum = new VoiceControlDecorator(new EnergySavingDecorator(vacuum));

        Device RemoteSmartLight = new RemoteAccessDecorator(new EnergySavingDecorator(light));
        Device RemoteSmartMusic = new RemoteAccessDecorator(new EnergySavingDecorator(musicSystem));
        Device RemoteSmartThermostat = new RemoteAccessDecorator(new EnergySavingDecorator(thermostat));
        Device RemoteSmartDoor = new RemoteAccessDecorator(new EnergySavingDecorator(door));
        Device RemoteSmartAC = new RemoteAccessDecorator(new EnergySavingDecorator(ac));
        Device RemoteSmartLock = new RemoteAccessDecorator(new EnergySavingDecorator(lock));
        Device RemoteSmartBlinds = new RemoteAccessDecorator(new EnergySavingDecorator(blinds));
        Device RemoteSmartVacuum = new RemoteAccessDecorator(new EnergySavingDecorator(vacuum));

        HomeAutomationFacade home = new HomeAutomationFacade(
            (Device)light, (Device)musicSystem, (Device)thermostat, (Device)camera, (Device)door
        );

        while (true) {
            System.out.println("\nChoose mode: [1] Remote Control  [2] Voice Control  [0] Exit");
            String choice = sc.nextLine();

            if (choice.equals("0")) {
                System.out.println("Goodbye.");
                door.turnOff();
                break;
            }

            if (choice.equals("1")) {
                System.out.println("\n=== Remote Control Options ===");
                System.out.println("Facade Commands:");
                System.out.println("[1] Start Party Mode");
                System.out.println("[2] Activate Night Mode");
                System.out.println("[3] Leave Home");
                System.out.println("\nDevice Controls:");
                System.out.println("[4] Light on/off");
                System.out.println("[5] Music on/off");
                System.out.println("[6] Thermostat (set temp)");
                System.out.println("[7] TV on");
                System.out.println("[8] Air Conditioner");
                System.out.println("[9] Smart Lock");
                System.out.println("[10] Smart Blinds");
                System.out.println("[11] Robot Vacuum");
                System.out.println("[0] Back to main menu");
                System.out.print("Choose: ");
                String opt = sc.nextLine();

                switch (opt) {
                    case "1": home.startPartyMode(); break;
                    case "2": home.activateNightMode(); break;
                    case "3": home.leaveHome(); break;
                    case "4": 
                        System.out.print("Light [1]On [2]Off: ");
                        if (sc.nextLine().equals("1")) RemoteSmartLight.turnOn();
                        else RemoteSmartLight.turnOff();
                        break;
                    case "5": 
                        System.out.print("Music [1]On [2]Off: ");
                        if (sc.nextLine().equals("1")) RemoteSmartMusic.turnOn();
                        else RemoteSmartMusic.turnOff();
                        break;
                    case "6": 
                        System.out.print("Enter temperature (°C): ");
                        int t = Integer.parseInt(sc.nextLine());
                        RemoteSmartThermostat.set(t); 
                        break;
                    case "7": tv.turnOn(); break;
                    case "8": 
                        System.out.println("AC: [1]On [2]Off [3]Set temp [4]Eco mode");
                        String acOpt = sc.nextLine();
                        if (acOpt.equals("1")) RemoteSmartAC.turnOn();
                        else if (acOpt.equals("2")) RemoteSmartAC.turnOff();
                        else if (acOpt.equals("3")) {
                            System.out.print("Temperature: ");
                            RemoteSmartAC.set(Integer.parseInt(sc.nextLine()));
                        }
                        else if (acOpt.equals("4")) RemoteSmartAC.ecoMode();
                        break;
                    case "9": 
                        System.out.print("Lock [1]Unlock [2]Lock: ");
                        if (sc.nextLine().equals("1")) RemoteSmartLock.turnOn();
                        else RemoteSmartLock.turnOff();
                        break;
                    case "10": 
                        System.out.println("Blinds: [1]Open [2]Close [3]Set level");
                        String blindOpt = sc.nextLine();
                        if (blindOpt.equals("1")) RemoteSmartBlinds.turnOn();
                        else if (blindOpt.equals("2")) RemoteSmartBlinds.turnOff();
                        else if (blindOpt.equals("3")) {
                            System.out.print("Level (0-100): ");
                            RemoteSmartBlinds.set(Integer.parseInt(sc.nextLine()));
                        }
                        break;
                    case "11": 
                        System.out.print("Vacuum [1]Start [2]Stop: ");
                        if (sc.nextLine().equals("1")) RemoteSmartVacuum.turnOn();
                        else RemoteSmartVacuum.turnOff();
                        break;
                    case "0": break;
                    default: System.out.println("Invalid option.");
                }
            }

            if (choice.equals("2")) {
                System.out.println("\n=== Voice Control Commands ===");
                System.out.println("Basic: 'light on/off', 'music on/off', 'volume 70', 'thermostat 25'");
                System.out.println("AC: 'ac on/off', 'ac temp 22', 'ac eco'");
                System.out.println("Lock: 'lock', 'unlock'");
                System.out.println("Blinds: 'blinds open', 'blinds close', 'blinds 50'");
                System.out.println("Vacuum: 'vacuum start', 'vacuum stop'");
                System.out.println("Modes: 'party mode', 'night mode', 'leave home'");
                System.out.println("Type 'exit' to return\n");
                
                while (true) {
                    System.out.print("Say command: ");
                    String cmd = sc.nextLine().toLowerCase();
                    
                    if (cmd.equals("exit")) break;
                    
                    // Light
                    if (cmd.equals("light on")) VoiceSmartLight.turnOn();
                    else if (cmd.equals("light off")) VoiceSmartLight.turnOff();
                    
                    // Music
                    else if (cmd.equals("music on")) VoiceSmartMusic.turnOn();
                    else if (cmd.equals("music off")) VoiceSmartMusic.turnOff();
                    else if (cmd.startsWith("volume")) {
                        int v = Integer.parseInt(cmd.split(" ")[1]);
                        VoiceSmartMusic.set(v);
                    }
                    
                    // Thermostat
                    else if (cmd.startsWith("thermostat")) {
                        int t = Integer.parseInt(cmd.split(" ")[1]);
                        VoiceSmartThermostat.set(t);
                    }
                    
                    // Air Conditioner
                    else if (cmd.equals("ac on")) VoiceSmartAC.turnOn();
                    else if (cmd.equals("ac off")) VoiceSmartAC.turnOff();
                    else if (cmd.startsWith("ac temp")) {
                        int temp = Integer.parseInt(cmd.split(" ")[2]);
                        VoiceSmartAC.set(temp);
                    }
                    else if (cmd.equals("ac eco")) VoiceSmartAC.ecoMode();
                    
                    // Smart Lock
                    else if (cmd.equals("unlock")) VoiceSmartLock.turnOn();
                    else if (cmd.equals("lock")) VoiceSmartLock.turnOff();
                    
                    // Smart Blinds
                    else if (cmd.equals("blinds open")) VoiceSmartBlinds.turnOn();
                    else if (cmd.equals("blinds close")) VoiceSmartBlinds.turnOff();
                    else if (cmd.startsWith("blinds ")) {
                        int level = Integer.parseInt(cmd.split(" ")[1]);
                        VoiceSmartBlinds.set(level);
                    }
                    
                    // Robot Vacuum
                    else if (cmd.equals("vacuum start")) VoiceSmartVacuum.turnOn();
                    else if (cmd.equals("vacuum stop")) VoiceSmartVacuum.turnOff();
                    
                    // Facade modes
                    else if (cmd.equals("party mode")) home.startPartyMode();
                    else if (cmd.equals("night mode")) home.activateNightMode();
                    else if (cmd.equals("leave home")) home.leaveHome();
                    
                    else System.out.println("Unknown command. Try 'light on', 'ac temp 22', 'unlock', 'blinds open', etc.");
                }
            }
        }
    }
}
