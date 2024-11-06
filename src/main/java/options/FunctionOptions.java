package options;

import java.sql.Connection;
import java.util.Scanner;

import sql.MenuOptionsSQL;

import tools.FromConsole;

public class FunctionOptions {

    // Rent equipment menu
    public static void rentEquipment(String customerId, Scanner scan, Connection conn) {
        String checkout = FromConsole.stringPrompt("Check out date (MM/DD/YYYY): ", scan);
        String dueDate = FromConsole.stringPrompt("Due date (MM/DD/YYYY): ", scan);
        String rentalFees = FromConsole.stringPrompt("Rental fees: ", scan);
        String serialNumber = FromConsole.stringPrompt("Equipment serial number: ", scan);
        MenuOptionsSQL.rentEquipment(customerId, checkout, dueDate, rentalFees, serialNumber, conn);
        System.out.println("Equipment rented successfully");
    }

    public static void returnEquipment(String customerId, Scanner scan, Connection conn) {
        String returnDate = FromConsole.stringPrompt("Return date (MM/DD/YYYY): ", scan);
        MenuOptionsSQL.returnEquipment(customerId, returnDate, conn);
        System.out.println("Equipment returned successfully");
    }

    public static void assignDroneToDelivery(String customerId, Scanner scan, Connection conn) {
        String droneId = FromConsole.stringPrompt("Drone Serial Number: ", scan);
        MenuOptionsSQL.assignDroneToDelivery(customerId, droneId, conn);
        System.out.println("Drone assigned to delivery successfully");
    }

    public static void assignDroneToPickup(String customerId, Scanner scan, Connection conn) {
        String droneId = FromConsole.stringPrompt("Drone Serial Number: ", scan);
        MenuOptionsSQL.assignDroneToPickup(customerId, droneId, conn);
        System.out.println("Drone assigned to pickup successfully");
    }
    
}
