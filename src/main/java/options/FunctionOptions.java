package options;

import java.util.Scanner;

import tools.FromConsole;

public class FunctionOptions {

    // Rent equipment menu
    public static void rentEquipment(String customerId, Scanner scan) {
        String checkout = FromConsole.stringPrompt("Check out date (MM/DD/YYYY): ", scan);
        String dueDate = FromConsole.stringPrompt("Due date (MM/DD/YYYY): ", scan);
        String rentalFees = FromConsole.stringPrompt("Rental fees: ", scan);
        String serialNumber = FromConsole.stringPrompt("Equipment serial number: ", scan);
        // TODO Create PreparedStatement and call SQLTools to query database
        System.out.println("Equipment rented successfully");
    }

    public static void returnEquipment(String customerId, Scanner scan) {
        String checkout = FromConsole.stringPrompt("Completed check out date (MM/DD/YYYY): ", scan);
        String equipmentSerialNumber = FromConsole.stringPrompt("Rented equipment serial number: ", scan);
        String returnDate = FromConsole.stringPrompt("Return date (MM/DD/YYYY): ", scan);
        // TODO Create PreparedStatement and call SQLTools to query database
        System.out.println("Equipment returned successfully");
    }

    public static void assignDroneToDelivery(String customerId, Scanner scan) {
        String checkout = FromConsole.stringPrompt("Completed check out date (MM/DD/YYYY): ", scan);
        String equipmentSerialNumber = FromConsole.stringPrompt("Rented equipment serial number: ", scan);
        String droneId = FromConsole.stringPrompt("Drone Serial Number: ", scan);
        // TODO Create PreparedStatement and call SQLTools to query database
        System.out.println("Drone assigned to delivery successfully");
    }

    public static void assignDroneToPickup(String customerId, Scanner scan) {
        String checkout = FromConsole.stringPrompt("Completed check out date (MM/DD/YYYY): ", scan);
        String equipmentSerialNumber = FromConsole.stringPrompt("Rented equipment serial number: ", scan);
        String droneId = FromConsole.stringPrompt("Drone Serial Number: ", scan);
        // TODO Create PreparedStatement and call SQLTools to query database
        System.out.println("Drone assigned to pickup successfully");
    }

}
