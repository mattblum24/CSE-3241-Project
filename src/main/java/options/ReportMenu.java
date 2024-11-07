package options;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import program.App;

import tools.FromConsole;
import tools.SQLTools;

public class ReportMenu {

    private static PreparedStatement ps;

    public static void reportMenu(Scanner scan) {
        int menuSelection = FromConsole.intPrompt("1: Renting checkouts. Find the total number of equipment items rented by a single member patron\n2: Popular item. Find the most popular item\n3: Popular Manufacturer. Find the most frequent equipment manufacturer in the database\n4: Popular Drone. Find the most used drone in the database\n5: Items checked out. Find the member who has rented out the most items and the total number of items they have rented out\n6: Equipment by Type of Equipment. Find the description (name) of equipment by type released before YEAR", scan);
    
        switch (menuSelection) {
            case 1:
                rentingCheckouts(scan);
                break;
            case 2:
                popularItem(scan);
                break;
            case 3:
                popularManufacturer(scan);
                break;
            case 4:
                popularDrone(scan);
                break;
            case 5:
                itemsCheckedOut(scan);
                break;
            case 6:
                equipmentByType(scan);
                break;
            default:
                break;
        }
    }

    public static void rentingCheckouts(Scanner scan) {
        int userId = Integer.parseInt(FromConsole.stringPrompt("Enter desired member's user id: ", scan));
        try {

            String sql = "SELECT serial_number, check_out " +
                        "FROM Customer JOIN Rental_Order ON Customer.user_id = rental_order.customer_user_id " +
                        "JOIN Equipment ON Rental_Order.equipment_serial_number = Equipment.serial_number " +
                        "WHERE Customer.user_id = ? ;";
            ps = App.conn.prepareStatement(sql);
            ps.setInt(1, userId);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        SQLTools.sqlQuery(App.conn, ps);
    }

    public static void popularItem(Scanner scan) {
        try {

            String sql = "SELECT serial_number, model, count(check_out) " + 
                            "FROM equipment JOIN rental_order ON equipment.serial_number = rental_order.equipment_serial_number " + 
                            "GROUP BY serial_number " + 
                            "ORDER BY count(check_out) DESC; ";
            ps = App.conn.prepareStatement(sql);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        SQLTools.sqlQuery(App.conn, ps);
    }

    public static void popularManufacturer(Scanner scan) {
        try {

            String sql = "SELECT Manufacturer.name, count(check_out)  " +   
                "FROM Rental_Order JOIN Equipment ON REntal_Order.equipment_serial_number = Equipment.serial_number  " +   
                "JOIN Manufacturer ON Equipment.manufacturer_phone = Manufacturer.phone  " +   
                "GROUP BY Manufacturer.name  " +   
                "ORDER BY count(check_out) DESC  " +   
                "LIMIT 1;";
            ps = App.conn.prepareStatement(sql);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        SQLTools.sqlQuery(App.conn, ps);
    }

    public static void popularDrone(Scanner scan) {
        try {

            String sql = "SELECT drone.serial_number, sum(4*warehouse_dist) AS TotalDistance, count(check_out) AS CheckOuts  " +   
                            "FROM Customer JOIN Rental_Order ON Customer.user_id = Rental_ORder.customer_user_id  " +   
                            "JOIN Drone ON Rental_Order.drone_serial_number = Drone.serial_number  " +   
                            "GROUP BY Drone.serial_number  " +   
                            "ORDER BY count(check_out) DESC;";
            ps = App.conn.prepareStatement(sql);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        SQLTools.sqlQuery(App.conn, ps);
    }

    public static void itemsCheckedOut(Scanner scan) {
        try {

            String sql = "SELECT max(equip_count), first_name, last_name " +  
                "FROM ( " +  
                "    SELECT count(equipment_serial_number) AS equip_count, first_name, last_name " +  
                "    FROM rental_order " +  
                "    JOIN customer on user_id = customer_user_id " +  
                "    GROUP BY customer_user_id " +  
                ");";
            ps = App.conn.prepareStatement(sql);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        SQLTools.sqlQuery(App.conn, ps);
    }

    public static void equipmentByType(Scanner scan) {
        String year = FromConsole.stringPrompt("Enter year: ", scan);
        try {

            String sql = "SELECT Equipment.model, type  " +   
                                "FROM Equipment  " +   
                                "JOIN Equip_Model on Equip_Model.model = Equipment.model  " +   
                                "WHERE Equipment.year > ? ;";
            ps = App.conn.prepareStatement(sql);
            ps.setString(1, year);
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        SQLTools.sqlQuery(App.conn, ps);
    }
}
