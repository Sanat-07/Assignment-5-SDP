import devices.*;
import decorators.*;
import facade.HomeAutomationFacade;
import user.User;
import user.UserDatabase;
import factory.DeviceFactory;
import factory.DeviceType;
import observer.*;

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
        
        Door door = (Door) DeviceFactory.createDevice(DeviceType.DOOR);
        Light light = (Light) DeviceFactory.createDevice(DeviceType.LIGHT);
        MusicSystem musicSystem = (MusicSystem) DeviceFactory.createDevice(DeviceType.MUSIC_SYSTEM);
        Thermostat thermostat = (Thermostat) DeviceFactory.createDevice(DeviceType.THERMOSTAT);
        SecurityCamera camera = (SecurityCamera) DeviceFactory.createDevice(DeviceType.SECURITY_CAMERA);
        SmartTv tv = (SmartTv) DeviceFactory.createDevice(DeviceType.SMART_TV);
        
        CameraObserver cameraObserver = new CameraObserver(camera);
        door.getSubject().attach(cameraObserver);
        
        TemperatureObserver tempObserver = new TemperatureObserver();
        thermostat.getSubject().attach(tempObserver);
        
        LightObserver lightObserver = new LightObserver(light);
        musicSystem.getSubject().attach(lightObserver);
        
        door.turnOn();

        Device VoiceSmartLight = new VoiceControlDecorator(new EnergySavingDecorator(light));
        Device VoiceSmartMusic = new VoiceControlDecorator(new EnergySavingDecorator(musicSystem));
        Device VoiceSmartThermostat = new VoiceControlDecorator(new EnergySavingDecorator(thermostat));
        Device VoiceSmartDoor = new VoiceControlDecorator(new EnergySavingDecorator(door));

        Device RemoteSmartLight = new RemoteAccessDecorator(new EnergySavingDecorator(light));
        Device RemoteSmartMusic = new RemoteAccessDecorator(new EnergySavingDecorator(musicSystem));
        Device RemoteSmartThermostat = new RemoteAccessDecorator(new EnergySavingDecorator(thermostat));
        Device RemoteSmartDoor = new RemoteAccessDecorator(new EnergySavingDecorator(door));

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
                System.out.println("Remote Control Options: ");
                System.out.println("[1] Start Party Mode");
                System.out.println("[2] Activate Night Mode");
                System.out.println("[3] Leave Home");
                System.out.println("[4] Switch to Voice Control");
                System.out.println("[5] Light on");
                System.out.println("[6] Light off");
                System.out.println("[7] Music on");
                System.out.println("[8] Music off");
                System.out.println("[9] set Thermostat");
                System.out.println("[10] TV");
                String opt = sc.nextLine();

                switch (opt) {
                    case "1": home.startPartyMode(); break;
                    case "2": home.activateNightMode(); break;
                    case "3": home.leaveHome(); break;
                    case "4": choice = "2"; break;
                    case "5": RemoteSmartLight.turnOn(); break;
                    case "6": RemoteSmartLight.turnOff(); break;
                    case "7": RemoteSmartMusic.turnOn(); break;
                    case "8": RemoteSmartMusic.turnOff(); break;
                    case "9": System.out.print("Enter temperature (°C): ");
                        int t = Integer.parseInt(sc.nextLine());
                        RemoteSmartThermostat.set(t); break;
                    case "10": tv.turnOn(); break;
                    default: System.out.println("Invalid option.");
                }
            }

            if (choice.equals("2")) {
                System.out.println("Voice commands: 'light on', 'light off', 'music on', 'music off', 'volume 70', 'thermostat 25', 'party mode', 'night mode', 'leave home', 'exit'");
                while (true) {
                    System.out.print("Say command: ");
                    String cmd = sc.nextLine().toLowerCase();
                    if (cmd.equals("exit")) break;
                    if (cmd.equals("light on")) VoiceSmartLight.turnOn();
                    else if (cmd.equals("light off")) VoiceSmartLight.turnOff();
                    else if (cmd.equals("music on")) VoiceSmartMusic.turnOn();
                    else if (cmd.equals("music off")) VoiceSmartMusic.turnOff();
                    else if (cmd.startsWith("volume")) {
                        int v = Integer.parseInt(cmd.split(" ")[1]);
                        VoiceSmartMusic.set(v);
                    } else if (cmd.startsWith("thermostat")) {
                        int t = Integer.parseInt(cmd.split(" ")[1]);
                        VoiceSmartLight.set(t);
                    } else if (cmd.equals("party mode")) home.startPartyMode();
                    else if (cmd.equals("night mode")) home.activateNightMode();
                    else if (cmd.equals("leave home")) home.leaveHome();
                    else System.out.println("Unknown command.");
                }
            }
        }
    }
}
