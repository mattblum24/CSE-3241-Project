package options;

import java.util.Scanner;

import tools.FromConsole;

public class DroneMenu {

    public static void droneMenu(Scanner scan) {
        int menuSelection = FromConsole.intPrompt("1: Add drone\n2: Remove drone\n3: List drones\n4: Search drones", scan);
        switch (menuSelection) {
            case 1:
                addDrone(scan);
                break;
            case 2:
                removeDrone(scan);
                break;
            case 3:
                listDrones();
                break;
            case 4:
                searchDrones(scan);
                break;
            default:
                break;
        }
    }

    public static void addDrone(Scanner scan) {
        String serialNumber = FromConsole.stringPrompt("Serial number: ", scan);
        String name = FromConsole.stringPrompt("Name: ", scan);
        String model = FromConsole.stringPrompt("Model: ", scan);
        int status = FromConsole.intPrompt("Status: ", scan);
        String year = FromConsole.stringPrompt("Year: ", scan);
        String warrantyExpiration = FromConsole.stringPrompt("Warranty expiration: ", scan);
        int availability = FromConsole.intPrompt("Availability: ", scan);
        String warehousePhone = FromConsole.stringPrompt("Warehouse phone: ", scan);
        String manufacturerPhone = FromConsole.stringPrompt("Manufacturer phone: ", scan);

        // TODO Create PreparedStatement and call SQLTools to query database

        System.out.println("Drone added successfully");
    }

    public static void removeDrone(Scanner scan) {
        String serialNumber = FromConsole.stringPrompt("Serial number: ", scan);

        // TODO Create PreparedStatement and call SQLTools to query database
        
        System.out.println("Drone removed successfully");
    }

    public static void listDrones() {
        // TODO Create PreparedStatement and call SQLTools to query database
    }

    public static void searchDrones(Scanner scan) {
        String serialNumber = FromConsole.stringPrompt("Serial number: ", scan);
        // TODO Create PreparedStatement and call SQLTools to query database

    }

}
