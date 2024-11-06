package options;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import tools.FromConsole;
import tools.SQLTools;
import program.App;

public class DroneMenu {

    private static PreparedStatement ps;

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

        try {
            String sql = "INSERT INTO Drone (serial_number, name, model, status, year, warranty_expiration, availability, warehouse_phone, manufacturer_phone) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            ps = App.conn.prepareStatement(sql);
            ps.setString(1, serialNumber);
            ps.setString(2, name);
            ps.setString(3, model);
            ps.setInt(4, status);
            ps.setString(5, year);
            ps.setString(6, warrantyExpiration);
            ps.setInt(7, availability);
            ps.setString(8, warehousePhone);
            ps.setString(9, manufacturerPhone);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Drone added successfully");
    }

    public static void removeDrone(Scanner scan) {
        String serialNumber = FromConsole.stringPrompt("Serial number: ", scan);

        try {
            String sql = "DELETE FROM Drone WHERE serial_number =  ?";
            ps = App.conn.prepareStatement(sql);
            ps.setString(1, serialNumber);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Drone removed successfully");
    }

    public static void listDrones() {
        try {
            String sql = "SELECT * FROM Drone";
            ps = App.conn.prepareStatement(sql);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        SQLTools.sqlQuery(App.conn, ps);
    }

    public static void searchDrones(Scanner scan) {
        String serialNumber = FromConsole.stringPrompt("Serial number: ", scan);
        
        try {
            String sql = "SELECT * FROM Drone WHERE serial_number =  ?";
            ps = App.conn.prepareStatement(sql);
            ps.setString(1, serialNumber);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        SQLTools.sqlQuery(App.conn, ps);

    }

}
