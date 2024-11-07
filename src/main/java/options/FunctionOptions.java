package options;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import tools.FromConsole;
import tools.SQLTools;
import program.App;


public class FunctionOptions {

    private static PreparedStatement ps;

    // Rent equipment menu
    public static void rentEquipment(String customerId, Scanner scan) {
        String checkout = FromConsole.stringPrompt("Check out date (MM/DD/YYYY): ", scan);
        String dueDate = FromConsole.stringPrompt("Due date (MM/DD/YYYY): ", scan);
        String rentalFees = FromConsole.stringPrompt("Rental fees: ", scan);
        String serialNumber = FromConsole.stringPrompt("Equipment serial number: ", scan);
        
        try {
            String sql = "INSERT INTO Rental_Order (check_out, due_date, rental_fees, equipment_serial_number, customer_user_id) " +
                "VALUES (?, ?, ?, ?, ?);";
            ps = App.conn.prepareStatement(sql);
            ps.setString(1, checkout);
            ps.setString(2, dueDate);
            ps.setString(3, rentalFees);
            ps.setString(4, serialNumber);
            ps.setString(5, customerId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        SQLTools.sqlUpdate(App.conn, ps);

        try {
            String sql = "UPDATE Equipment SET availability = 0 WHERE serial_number = ?;";
            ps = App.conn.prepareStatement(sql);
            ps.setString(1, serialNumber);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Equipment rented successfully");
    }

    public static void returnEquipment(String customerId, Scanner scan) {
        String checkout = FromConsole.stringPrompt("Completed check out date (MM/DD/YYYY): ", scan);
        String equipmentSerialNumber = FromConsole.stringPrompt("Rented equipment serial number: ", scan);
        String returnDate = FromConsole.stringPrompt("Return date (MM/DD/YYYY): ", scan);

        try {
            String sql = "UPDATE Rental_Order SET return_date = ? WHERE customer_user_id = ? AND equipment_serial_number = ? AND check_out = ?;";
            ps = App.conn.prepareStatement(sql);
            ps.setString(1, returnDate);
            ps.setString(2, customerId);
            ps.setString(3, equipmentSerialNumber);
            ps.setString(4, checkout);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        SQLTools.sqlUpdate(App.conn, ps);

        try {
            String sql = "UPDATE Equipment SET availability = 1 WHERE serial_number = ?;";
            ps = App.conn.prepareStatement(sql);
            ps.setString(1, equipmentSerialNumber);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Equipment returned successfully");
    }

    public static void assignDroneToDelivery(String customerId, Scanner scan) {
        String checkout = FromConsole.stringPrompt("Completed check out date (MM/DD/YYYY): ", scan);
        String equipmentSerialNumber = FromConsole.stringPrompt("Rented equipment serial number: ", scan);
        String droneId = FromConsole.stringPrompt("Drone Serial Number: ", scan);

        try {
            String sql = "UPDATE Rental_Order SET drone_serial_number = ? WHERE customer_user_id = ? AND equipment_serial_number = ? AND check_out = ?;";
            ps = App.conn.prepareStatement(sql);
            ps.setString(1, droneId);
            ps.setString(2, customerId);
            ps.setString(3, equipmentSerialNumber);
            ps.setString(4, checkout);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        SQLTools.sqlUpdate(App.conn, ps);

        System.out.println("Drone assigned to delivery successfully");
    }

    public static void assignDroneToPickup(String customerId, Scanner scan) {
        String checkout = FromConsole.stringPrompt("Completed check out date (MM/DD/YYYY): ", scan);
        String equipmentSerialNumber = FromConsole.stringPrompt("Rented equipment serial number: ", scan);
        String droneId = FromConsole.stringPrompt("Drone Serial Number: ", scan);
        
        try {
            String sql = "UPDATE Rental_Order SET drone_serial_number = ? WHERE customer_user_id = ? AND equipment_serial_number = ? AND check_out = ?;";
            ps = App.conn.prepareStatement(sql);
            ps.setString(1, droneId);
            ps.setString(2, customerId);
            ps.setString(3, equipmentSerialNumber);
            ps.setString(4, checkout);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        SQLTools.sqlUpdate(App.conn, ps);

        System.out.println("Drone assigned to pickup successfully");
    }

}
