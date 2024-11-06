package options;

import java.sql.Connection;
import java.util.Scanner;

import entities.Drone;
import sql.DroneSQL;
import tools.FromConsole;

public class DroneMenu {

    public static void droneMenu(Scanner scan,  Connection conn) {
        int menuSelection = FromConsole.intPrompt("1: Add drone\n2: Remove drone\n3: List drones\n4: Search drones", scan);
        switch (menuSelection) {
            case 1:
                addDrone(scan, conn);
                break;
            case 2:
                removeDrone(scan, conn);
                break;
            case 3:
                listDrones(conn);
                break;
            case 4:
                searchDrones(scan, conn);
                break;
            default:
                break;
        }
    }

    public static void addDrone(Scanner scan, Connection conn) {
        String serialNumber = FromConsole.stringPrompt("Serial number: ", scan);
        String name = FromConsole.stringPrompt("Name: ", scan);
        String model = FromConsole.stringPrompt("Model: ", scan);
        int status = FromConsole.intPrompt("Status: ", scan);
        String year = FromConsole.stringPrompt("Year: ", scan);
        String warrantyExpiration = FromConsole.stringPrompt("Warranty expiration: ", scan);
        int availability = FromConsole.intPrompt("Availability: ", scan);
        String warehousePhone = FromConsole.stringPrompt("Warehouse phone: ", scan);
        String manufacturerPhone = FromConsole.stringPrompt("Manufacturer phone: ", scan);

        Drone drone = new Drone(serialNumber, name, model, status, year, warrantyExpiration, availability, warehousePhone, manufacturerPhone);

        DroneSQL.addDrone(conn, drone);
        System.out.println("Drone added successfully");
    }

    public static void removeDrone(Scanner scan, Connection conn) {
        String serialNumber = FromConsole.stringPrompt("Serial number: ", scan);

        DroneSQL.removeDrone(conn, serialNumber);
        System.out.println("Drone removed successfully");
    }

    public static void listDrones(Connection conn) {
        // TODO: Call DroneSQL and print out the results
    }

    public static void searchDrones(Scanner scan, Connection conn) {
        String serialNumber = FromConsole.stringPrompt("Serial number: ", scan);
        // TODO: Call DroneSQL and print out the results
        // Drone drone = droneRepository.get(serialNumber);
        // System.out.println("Name: " + drone.getName());
        // System.out.println("Model: " + drone.getModel());
        // System.out.println("Status: " + Integer.toString(drone.getStatus()));
        // System.out.println("Year: " + drone.getYear());
        // System.out.println("Warranty expiration: " + drone.getWarrantyExpiration());
        // System.out.println("Availability: " + Integer.toString(drone.getAvailability()));
        // System.out.println("Warehouse phone: " + drone.getWarehousePhone());
        // System.out.println("Manufacturer phone: " + drone.getManufacturerPhone());
    }

}
