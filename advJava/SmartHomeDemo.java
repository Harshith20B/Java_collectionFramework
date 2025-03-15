package advJava;

import java.util.Scanner;
abstract class Device {
    protected RemoteControl control;
    
    public Device(RemoteControl control) {
        this.control = control;
    }
    
    abstract void turnOn();
    abstract void turnOff();
    
    public void setControl(RemoteControl control) {
        this.control = control;
    }
}

class SmartLight extends Device {
    public SmartLight(RemoteControl control) {
        super(control);
    }
    
    @Override
    public void turnOn() {
        System.out.print("Smart Light: ");
        control.operate();
    }
    
    @Override
    public void turnOff() {
        System.out.println("Smart Light: Turning off");
    }
}

class SmartThermostat extends Device {
    public SmartThermostat(RemoteControl control) {
        super(control);
    }
    
    @Override
    public void turnOn() {
        System.out.print("Smart Thermostat: ");
        control.operate();
    }
    
    @Override
    public void turnOff() {
        System.out.println("Smart Thermostat: Turning off");
    }
}

interface RemoteControl {
    void operate();
    void configure();
}

class BasicRemote implements RemoteControl {
    @Override
    public void operate() {
        System.out.println("Basic remote operation");
    }
    
    @Override
    public void configure() {
        System.out.println("Basic configuration");
    }
}

class AdvancedRemote implements RemoteControl {
    @Override
    public void operate() {
        System.out.println("Advanced remote operation with additional features");
    }
    
    @Override
    public void configure() {
        System.out.println("Advanced configuration with automation");
    }
    
    public void setupAutomation() {
        System.out.println("Setting up automated schedules");
    }
}

class SmartHomeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose remote control type:");
        System.out.println("1. Basic Remote");
        System.out.println("2. Advanced Remote");
        int remoteChoice = scanner.nextInt();
        
        RemoteControl selectedRemote = null;
        if (remoteChoice == 1) {
            selectedRemote = new BasicRemote();
        } else if (remoteChoice == 2) {
            selectedRemote = new AdvancedRemote();
        } else {
            System.out.println("Invalid choice, defaulting to Basic Remote.");
            selectedRemote = new BasicRemote();
        }
        
        System.out.println("Choose device type:");
        System.out.println("1. Smart Light");
        System.out.println("2. Smart Thermostat");
        int deviceChoice = scanner.nextInt();
        
        Device selectedDevice = null;
        if (deviceChoice == 1) {
            selectedDevice = new SmartLight(selectedRemote);
        } else if (deviceChoice == 2) {
            selectedDevice = new SmartThermostat(selectedRemote);
        } else {
            System.out.println("Invalid choice, defaulting to Smart Light.");
            selectedDevice = new SmartLight(selectedRemote);
        }
        
        selectedDevice.turnOn();
        selectedDevice.turnOff();
        
        if (selectedRemote instanceof AdvancedRemote) {
            System.out.println("Do you want to set up automation? (yes/no)");
            String setupChoice = scanner.next();
            if ("yes".equalsIgnoreCase(setupChoice)) {
                ((AdvancedRemote) selectedRemote).setupAutomation();
            }
        }
        
        scanner.close();
    }
}